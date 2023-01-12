package com.example.shrine

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shrine.ui.theme.ShrineTheme
import java.util.*

@Composable
fun Cart() {
    Surface(
        color = MaterialTheme.colors.secondary
    ) {
        val rememberScrollState = rememberScrollState()

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState)
        ) {

            CartHeader()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
//                LazyColumn {
//                    items(SampleItems) { i ->
//                        CartItem(i)
//                    }
//                }

                SampleItems.forEach { item ->
                    CartItem(item)
                }
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.AddShoppingCart,
                    contentDescription = "Add to card icon"
                )
                Spacer(Modifier.width(16.dp))
                Text("Add to cart".uppercase())
            }
        }

    }

}


@Composable
private fun CartHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Arrow Drop Down"
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Cart".uppercase(),
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "${SampleItems.size} Items".uppercase())
    }
}

@Preview(name = "Header Cart", showBackground = true)
@Composable
fun CartHeaderPreview() {
    ShrineTheme {
        CartHeader()
    }
}

@Preview(name = "Item Cart", showBackground = true)
@Composable
fun ItemCartPreview() {
    ShrineTheme {
        CartItem(SampleItems[0])
    }
}

@Preview(name = "Full Cart", device = Devices.PIXEL_4)
@Composable
fun CartPreview() {
    ShrineTheme {
        Cart()
    }
}