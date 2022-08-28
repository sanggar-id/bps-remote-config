package id.sanggar.bpsabtesting.domain.interactor

import id.sanggar.bpsabtesting.data.entity.Ad
import id.sanggar.bpsabtesting.data.repository.AdRepository
import id.sanggar.remoteconfig.RemoteConfig

class AdRepositoryImpl constructor(
    private val remoteConfig: RemoteConfig
) : AdRepository {

    override fun adBanner(): Ad {
        return if (remoteConfig.getBoolean(RC_NEW_BANNER)) new() else old()
    }

    private fun old(): Ad {
        return Ad(
            title = "Promo Makan Gratis!",
            description = "Ayo datang ke gerai kami dan nikmati makanan gratis!",
        )
    }

    private fun new(): Ad {
        return Ad(
            title = "[BARU!!] Promo Makan Gratis Sepuasnys!",
            description = "Ada yang baru, ayo buruan datang ke gerai kami!",
        )
    }

    companion object {
        private const val RC_NEW_BANNER = "ad_new_banner"
    }

}