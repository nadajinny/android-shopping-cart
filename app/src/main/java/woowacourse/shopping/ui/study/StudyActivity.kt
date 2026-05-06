package woowacourse.shopping.ui.study

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import woowacourse.shopping.ui.cart.CartActivity
import woowacourse.shopping.ui.theme.ShoppingTheme
import kotlin.getValue

class StudyActivity : ComponentActivity() {
    private val viewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()


            ShoppingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CartScreen(
                        quantity = uiState.quantity,
                        onClick = viewModel::addItem,
                        onPass = {
                            startActivity(Intent(this, CartActivity::class.java))
                        },
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}
