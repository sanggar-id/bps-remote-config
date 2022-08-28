package id.sanggar.bpsabtesting.ui

import android.os.Bundle
import android.view.ViewStub
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.sanggar.bpsabtesting.R
import id.sanggar.bpsabtesting.di.FeatureModule
import id.sanggar.bpsabtesting.domain.state.UiState
import id.sanggar.bpsabtesting.domain.uimodel.AdUiModel
import id.sanggar.bpsabtesting.domain.uimodel.CashbackUiModel
import id.sanggar.bpsabtesting.domain.uimodel.FoodUiModel
import kotlin.LazyThreadSafetyMode.NONE

class MainActivity : AppCompatActivity(), MainView {

    private val viewStubBanner: ViewStub by lazy(NONE) { findViewById(R.id.vs_banner) }
    private val lstFood: TextView by lazy(NONE) { findViewById(R.id.lst_food) }

    private val presenter by lazy {
        FeatureModule.getMainPresenter(this)
    }

    // simulated
    private val userId = 789

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getCashbackData()
        presenter.getAd()
        presenter.getFood()
    }

    override fun onAdResult(data: AdUiModel) {
        val view = viewStubBanner.inflate()

        val txtTitle = view.findViewById<TextView>(R.id.txt_title)
        val txtDesc = view.findViewById<TextView>(R.id.txt_description)

        txtTitle.text = data.title
        txtDesc.text = data.description
    }

    override fun onFoodListResult(data: UiState<List<FoodUiModel>>) {
        when (data) {
            is UiState.Success -> {
                val result = data.result.simplified()
                lstFood.text = result
            }
            is UiState.Error -> {
                lstFood.text = data.message
            }
        }
    }

    override fun onCashbackResult(cashback: UiState<CashbackUiModel>) {
        when (cashback) {
            is UiState.Success -> {
                val message = cashback.result.message
                val defaultAmount = cashback.result.amount
                val user = cashback.result.user.firstOrNull { it.userId == userId }

                showToast("$message dengan cashback ${user?.amount ?: defaultAmount}%")
            }
            is UiState.Error -> {
                showToast(cashback.message)
            }
        }
    }

    private fun FoodUiModel.toReadable(): String {
        return "$name dengan harga $price"
    }

    private fun List<FoodUiModel>.simplified(): String {
        var result = ""

        this.map {
            it.toReadable()
        }.map {
            result += "$it \n\n"
        }

        return result
    }

    private fun showToast(message: String) {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

}