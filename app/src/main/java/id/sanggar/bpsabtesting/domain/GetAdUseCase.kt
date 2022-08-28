package id.sanggar.bpsabtesting.domain

import id.sanggar.bpsabtesting.base.UseCase
import id.sanggar.bpsabtesting.data.repository.AdRepository
import id.sanggar.bpsabtesting.domain.uimodel.AdUiModel

class GetAdUseCase constructor(
    private val repository: AdRepository
) : UseCase<Unit, AdUiModel>() {

    override fun execute(param: Unit): AdUiModel {
        val result = repository.adBanner()

        return AdUiModel(
            title = result.title,
            description = result.description,
        )
    }

}