package id.sanggar.bpsabtesting.domain.interactor

import id.sanggar.bpsabtesting.data.entity.Food
import id.sanggar.bpsabtesting.data.repository.FoodRepository

class FoodRepositoryImpl : FoodRepository {
    override fun invoke(): List<Food> {
        return listOf(
            Food("Nasi Goreng", "Rp.10,000"),
            Food("Pecel Ayam", "Rp.18,000"),
            Food("Ketoprak", "Rp.8,000"),
        )
    }
}