package id.sanggar.bpsabtesting.domain

import id.sanggar.bpsabtesting.base.UseCase
import id.sanggar.bpsabtesting.data.entity.FoodCashback
import id.sanggar.bpsabtesting.data.repository.CashbackRepository
import id.sanggar.bpsabtesting.domain.state.UiState
import id.sanggar.bpsabtesting.domain.uimodel.CashbackUiModel

class GetCashbackUseCase constructor(
    private val repository: CashbackRepository
) : UseCase<Unit, UiState<CashbackUiModel>>() {

    override fun execute(param: Unit): UiState<CashbackUiModel> {
        return repository.cashback().map()
    }

    private fun FoodCashback?.map(): UiState<CashbackUiModel> {
        return if (this != null) {
            UiState.Success(CashbackUiModel(
                message = message,
                amount = amount,
                user = user
            ))
        } else {
            UiState.Error("Tidak ada cashback tersedia.")
        }
    }

}