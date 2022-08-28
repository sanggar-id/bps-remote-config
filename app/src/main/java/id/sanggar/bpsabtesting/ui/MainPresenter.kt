package id.sanggar.bpsabtesting.ui

import id.sanggar.bpsabtesting.domain.GetAdUseCase
import id.sanggar.bpsabtesting.domain.GetCashbackUseCase
import id.sanggar.bpsabtesting.domain.GetFoodUseCase

class MainPresenter constructor(
    private val adUseCase: GetAdUseCase,
    private val foodUseCase: GetFoodUseCase,
    private val cashbackUseCase: GetCashbackUseCase,
    private val view: MainView
) {

    fun getCashbackData() {
        val result = cashbackUseCase.execute(Unit)
        view.onCashbackResult(result)
    }

    fun getAd() {
        val result = adUseCase.execute(Unit)
        view.onAdResult(result)
    }

    fun getFood() {
        val result = foodUseCase.execute(Unit)
        view.onFoodListResult(result)
    }

}