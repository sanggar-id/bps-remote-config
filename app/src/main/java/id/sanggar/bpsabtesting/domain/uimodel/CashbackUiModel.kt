package id.sanggar.bpsabtesting.domain.uimodel

import id.sanggar.bpsabtesting.data.entity.User

data class CashbackUiModel(
    val message: String,
    val amount: Int,
    val user: List<User>
)