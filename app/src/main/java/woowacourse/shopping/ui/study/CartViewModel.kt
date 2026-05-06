package woowacourse.shopping.ui.study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CartUiState(
    val quantity: Int,
    val isLoading: Boolean = false,
)

class CartViewModel : ViewModel() {

    // 쓰기 가능한 StateFlow - ViewModel 내부에서만 상태를 변경한다
    private val _uiState = MutableStateFlow(CartUiState(quantity = 0, isLoading = false))

    // 읽기 전용 StateFlow - 외부(Composable)에 노출한다
    // asStateFlow()로 MutableStateFlow를 읽기 전용으로 래핑한다
    // 외부에서 상태를 직접 변경하지 못하도록 막는 것이 목적이다
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    fun addItem() {
        // update { }: 현재 상태를 받아 새 상태를 반환하는 원자적 갱신
        // 스레드 안전하게 상태를 교체한다
        _uiState.update {
            // copy(): data class의 불변 갱신 - 기존 상태를 직접 수정하지 않고
            // 변경된 부분만 새 객체로 만든다
            it.copy(quantity = it.quantity + 1)
        }
    }
}
