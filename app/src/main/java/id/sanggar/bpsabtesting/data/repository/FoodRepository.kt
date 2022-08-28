package id.sanggar.bpsabtesting.data.repository

import id.sanggar.bpsabtesting.data.entity.Food

interface FoodRepository {
    fun foodList(): List<Food>?
}