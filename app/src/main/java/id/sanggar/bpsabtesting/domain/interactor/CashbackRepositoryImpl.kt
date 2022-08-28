package id.sanggar.bpsabtesting.domain.interactor

import com.google.gson.Gson
import id.sanggar.bpsabtesting.data.entity.Cashback
import id.sanggar.bpsabtesting.data.entity.FoodCashback
import id.sanggar.bpsabtesting.data.repository.CashbackRepository
import id.sanggar.remoteconfig.RemoteConfig

class CashbackRepositoryImpl constructor(
    private val remoteConfig: RemoteConfig
) : CashbackRepository {

    override fun cashback(): FoodCashback? {
        val json = remoteConfig.getString(KEY_CASHBACK)
        val cashback = Gson().fromJson(json, Cashback::class.java)
        return cashback?.foodCashback
    }

    companion object {
        private const val KEY_CASHBACK = "food_cashback"
    }

}