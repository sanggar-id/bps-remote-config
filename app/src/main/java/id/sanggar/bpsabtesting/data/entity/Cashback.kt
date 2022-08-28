package id.sanggar.bpsabtesting.data.entity

import com.google.gson.annotations.SerializedName

data class Cashback(
    @SerializedName("cashback_makanan")
    val foodCashback: FoodCashback
)

data class FoodCashback(
    @SerializedName("message")
    val message: String,

    @SerializedName("amount")
    val amount: Int,

    @SerializedName("user")
    val user: List<User>
)

data class User(
    @SerializedName("user_id")
    val userId: Int,

    @SerializedName("amount")
    val amount: Int
)