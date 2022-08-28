package id.sanggar.bpsabtesting.domain

import id.sanggar.bpsabtesting.base.UseCase
import id.sanggar.bpsabtesting.data.entity.Food
import id.sanggar.bpsabtesting.data.repository.FoodRepository
import id.sanggar.bpsabtesting.domain.state.UiState
import id.sanggar.bpsabtesting.domain.uimodel.FoodUiModel

class GetFoodUseCase constructor(
    private val repository: FoodRepository
) : UseCase<Unit, UiState<List<FoodUiModel>>>() {

    override fun execute(param: Unit): UiState<List<FoodUiModel>> {
        return repository.foodList().map()
    }

    private fun List<Food>?.map(): UiState<List<FoodUiModel>> {
        return if (this != null) {
            UiState.Success(this.map {
                FoodUiModel(
                    name = it.name,
                    price = it.price,
                )
            })
        } else {
            UiState.Error("Daftar makanan tidak ditemukan!")
        }
    }

}