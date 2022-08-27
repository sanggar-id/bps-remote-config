package id.sanggar.bpsabtesting.ui

import android.os.Bundle
import android.view.ViewStub
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.sanggar.bpsabtesting.R
import id.sanggar.bpsabtesting.di.FeatureModule
import id.sanggar.bpsabtesting.domain.uimodel.AdUiModel
import id.sanggar.bpsabtesting.domain.uimodel.FoodUiModel
import kotlin.LazyThreadSafetyMode.NONE

class MainActivity : AppCompatActivity(), MainView {

    private val viewStubBanner: ViewStub by lazy(NONE) { findViewById(R.id.vs_banner) }
    private val lstFood: TextView by lazy(NONE) { findViewById(R.id.lst_food) }

    private val presenter by lazy {
        FeatureModule.getMainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    override fun onFoodListResult(data: List<FoodUiModel>) {
        var result = ""

        data.map {
            it.toReadable()
        }.map {
            result += "$it \n\n"
        }

        lstFood.text = result
    }

    private fun FoodUiModel.toReadable(): String {
        return "$name dengan harga $price"
    }

}