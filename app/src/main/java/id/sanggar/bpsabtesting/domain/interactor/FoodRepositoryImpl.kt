package id.sanggar.bpsabtesting.domain.interactor

import com.google.gson.Gson
import id.sanggar.bpsabtesting.data.entity.Food
import id.sanggar.bpsabtesting.data.entity.FoodList
import id.sanggar.bpsabtesting.data.repository.FoodRepository
import id.sanggar.remoteconfig.RemoteConfig

class FoodRepositoryImpl constructor(
    private val remoteConfig: RemoteConfig
) : FoodRepository {

    override fun foodList(): List<Food>? {
        val json = remoteConfig.getString(KEY_AB_FOOD_LIST)
        val foodListResponse = Gson().fromJson(json, FoodList::class.java)
        return foodListResponse?.foodList
    }

    companion object {
        private const val KEY_AB_FOOD_LIST = "food_list"
    }
}