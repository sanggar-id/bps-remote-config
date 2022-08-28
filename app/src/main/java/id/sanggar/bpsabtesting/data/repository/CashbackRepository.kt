package id.sanggar.bpsabtesting.data.repository

import id.sanggar.bpsabtesting.data.entity.FoodCashback

interface CashbackRepository {
    fun cashback(): FoodCashback?
}