package id.sanggar.bpsabtesting.di

import id.sanggar.bpsabtesting.ui.MainPresenter
import id.sanggar.bpsabtesting.ui.MainView

object FeatureModule {

    fun getMainPresenter(view: MainView): MainPresenter {
        return MainPresenter(
            DataModule.getAdUseCase(),
            DataModule.getFoodUseCase(),
            DataModule.getCashbackUseCase(),
            view
        )
    }

}