package id.sanggar.bpsabtesting.domain

import id.sanggar.bpsabtesting.base.UseCase
import id.sanggar.bpsabtesting.data.repository.AdRepository
import id.sanggar.bpsabtesting.domain.uimodel.AdUiModel

class GetAdUseCase constructor(
    private val repository: AdRepository
) : UseCase<Boolean, AdUiModel>() {

    override fun execute(param: Boolean): AdUiModel {
        val result = if (param) {
            repository.new()
        } else {
            repository.old()
        }

        return AdUiModel(
            title = result.title,
            description = result.description,
        )
    }

}