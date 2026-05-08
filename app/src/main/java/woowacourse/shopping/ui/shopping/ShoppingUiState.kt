package woowacourse.shopping.ui.shopping

data class ShoppingUiState(
    val products: List<ShoppingProductUiModel> = emptyList(),
    val cartQuantity: Int = 0,
    val hasNext: Boolean = false,
    val isLoading: Boolean = false,
)
