package id.sanggar.bpsabtesting.domain

import id.sanggar.bpsabtesting.base.UseCase
import id.sanggar.bpsabtesting.data.repository.FoodRepository
import id.sanggar.bpsabtesting.domain.uimodel.FoodUiModel

class GetFoodUseCase constructor(
    private val repository: FoodRepository
) : UseCase<Unit, List<FoodUiModel>>() {

    override fun execute(param: Unit): List<FoodUiModel> {
        return repository.invoke().map {
            FoodUiModel(
                name = it.name,
                price = it.price,
            )
        }
    }

}