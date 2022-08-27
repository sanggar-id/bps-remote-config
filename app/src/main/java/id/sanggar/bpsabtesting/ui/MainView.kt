package id.sanggar.bpsabtesting.ui

import id.sanggar.bpsabtesting.domain.uimodel.AdUiModel
import id.sanggar.bpsabtesting.domain.uimodel.FoodUiModel

interface MainView {
    fun onAdResult(data: AdUiModel)
    fun onFoodListResult(data: List<FoodUiModel>)
}