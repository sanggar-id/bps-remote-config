package id.sanggar.bpsabtesting.di

import id.sanggar.bpsabtesting.data.repository.AdRepository
import id.sanggar.bpsabtesting.data.repository.CashbackRepository
import id.sanggar.bpsabtesting.data.repository.FoodRepository
import id.sanggar.bpsabtesting.domain.GetAdUseCase
import id.sanggar.bpsabtesting.domain.GetCashbackUseCase
import id.sanggar.bpsabtesting.domain.GetFoodUseCase
import id.sanggar.bpsabtesting.domain.interactor.AdRepositoryImpl
import id.sanggar.bpsabtesting.domain.interactor.CashbackRepositoryImpl
import id.sanggar.bpsabtesting.domain.interactor.FoodRepositoryImpl
import id.sanggar.remoteconfig.module.RemoteConfigModule

object DataModule {

    private fun provideAdRepository(): AdRepository {
        return AdRepositoryImpl(
            RemoteConfigModule.get()
        )
    }

    private fun provideFoodRepository(): FoodRepository {
        return FoodRepositoryImpl(
            RemoteConfigModule.get()
        )
    }

    private fun provideCashbackRepository(): CashbackRepository {
        return CashbackRepositoryImpl(
            RemoteConfigModule.get()
        )
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

    private fun provideGetCashbackUseCase(
        repository: CashbackRepository
    ): GetCashbackUseCase {
        return GetCashbackUseCase(repository)
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

    fun getCashbackUseCase(): GetCashbackUseCase {
        return provideGetCashbackUseCase(
            provideCashbackRepository()
        )
    }

}