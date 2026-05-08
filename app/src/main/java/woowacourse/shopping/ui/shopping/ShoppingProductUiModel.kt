package woowacourse.shopping.ui.shopping

import woowacourse.shopping.model.Product

data class ShoppingProductUiModel(
    val product: Product,
    val quantity: Int,
) {
    val isInCart: Boolean
        get() = quantity > 0
}