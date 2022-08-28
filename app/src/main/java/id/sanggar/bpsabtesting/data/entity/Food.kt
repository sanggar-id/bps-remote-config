package id.sanggar.bpsabtesting.data.entity

import com.google.gson.annotations.SerializedName

data class FoodList(
    @SerializedName("food_list")
    val foodList: List<Food>
)

data class Food(
    @SerializedName("name")
    val name: String,

    @SerializedName("price")
    val price: String
)