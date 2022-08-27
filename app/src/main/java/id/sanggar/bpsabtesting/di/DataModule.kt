package id.sanggar.bpsabtesting.di

import id.sanggar.bpsabtesting.data.repository.AdRepository
import id.sanggar.bpsabtesting.data.repository.FoodRepository
import id.sanggar.bpsabtesting.domain.GetAdUseCase
import id.sanggar.bpsabtesting.domain.GetFoodUseCase
import id.sanggar.bpsabtesting.domain.interactor.AdRepositoryImpl
import id.sanggar.bpsabtesting.domain.interactor.FoodRepositoryImpl

object DataModule {

    private fun provideAdRepository(): AdRepository {
        return AdRepositoryImpl()
    }

    private fun provideFoodRepository(): FoodRepository {
        return FoodRepositoryImpl()
    }

    private fun provideAdUseCase(
        repository: AdRepository
    ): GetAdUseCase {
        return GetAdUseCase(repository)
    }

    private fun provideFoodUseCase(
        repository: FoodRepository
    ): GetFoodUseCase {
        return GetFoodUseCase(repository)
    }

    fun getAdUseCase(): GetAdUseCase {
        return provideAdUseCase(
            provideAdRepository()
        )
    }

    fun getFoodUseCase(): GetFoodUseCase {
        return provideFoodUseCase(
            provideFoodRepository()
        )
    }

}