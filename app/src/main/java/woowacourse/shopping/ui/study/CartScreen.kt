package woowacourse.shopping.ui.study

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CartScreen(
    quantity: Int,
    onClick: () -> Unit,
    onPass: () -> Unit,
    modifier: Modifier = Modifier)
{

    Column(
        modifier = modifier
    ) {
        Text("수량: $quantity")
        Button(onClick = onClick) { Text("담기") }
        Button(onClick = onPass) { Text("이동") }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    CartScreen(
        quantity = 1, onClick = {}, onPass = {}
    )
}