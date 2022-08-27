package id.sanggar.bpsabtesting.ui

import id.sanggar.bpsabtesting.domain.GetAdUseCase
import id.sanggar.bpsabtesting.domain.GetFoodUseCase
import id.sanggar.remoteconfig.RemoteConfig

class MainPresenter constructor(
    private val adUseCase: GetAdUseCase,
    private val foodUseCase: GetFoodUseCase,
    private val remoteConfig: RemoteConfig,
    private val view: MainView
) {

    fun getAd() {
        val isBannerNew = remoteConfig.getBoolean(RC_NEW_BANNER)
        val result = adUseCase.execute(isBannerNew)

        view.onAdResult(result)
    }

    fun getFood() {
        val result = foodUseCase.execute(Unit)
        view.onFoodListResult(result)
    }

    companion object {
        private const val RC_NEW_BANNER = "ad_new_banner"
    }

}