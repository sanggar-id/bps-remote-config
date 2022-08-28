package id.sanggar.bpsabtesting.ui

import id.sanggar.bpsabtesting.domain.state.UiState
import id.sanggar.bpsabtesting.domain.uimodel.AdUiModel
import id.sanggar.bpsabtesting.domain.uimodel.CashbackUiModel
import id.sanggar.bpsabtesting.domain.uimodel.FoodUiModel

interface MainView {
    fun onAdResult(data: AdUiModel)
    fun onFoodListResult(data: UiState<List<FoodUiModel>>)
    fun onCashbackResult(cashback: UiState<CashbackUiModel>)
}