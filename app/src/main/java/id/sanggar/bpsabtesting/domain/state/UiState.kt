package id.sanggar.bpsabtesting.domain.state

sealed class UiState<out T: Any> {
    class Success<out T: Any>(val result: T): UiState<T>()
    class Error(val message: String): UiState<Nothing>()
}