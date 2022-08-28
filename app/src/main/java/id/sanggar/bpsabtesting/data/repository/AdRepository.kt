package id.sanggar.bpsabtesting.data.repository

import id.sanggar.bpsabtesting.data.entity.Ad

interface AdRepository {
    fun adBanner(): Ad
}