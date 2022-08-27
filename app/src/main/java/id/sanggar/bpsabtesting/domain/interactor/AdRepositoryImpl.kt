package id.sanggar.bpsabtesting.domain.interactor

import id.sanggar.bpsabtesting.data.entity.Ad
import id.sanggar.bpsabtesting.data.repository.AdRepository

class AdRepositoryImpl : AdRepository {
    override fun old(): Ad {
        return Ad(
            title = "Promo Makan Gratis!",
            description = "Ayo datang ke gerai kami dan nikmati makanan gratis!",
        )
    }

    override fun new(): Ad {
        return Ad(
            title = "[BARU!!] Promo Makan Gratis Sepuasnys!",
            description = "Ada yang baru, ayo buruan datang ke gerai kami!",
        )
    }
}