package id.sanggar.bpsabtesting.data.repository

import id.sanggar.bpsabtesting.data.entity.Food

interface FoodRepository {
    operator fun invoke(): List<Food>
}