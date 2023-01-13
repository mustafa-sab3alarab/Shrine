package com.example.shrine

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shrine.ui.theme.ShrineTheme

@Composable
fun CartItem(item: CartDataItem) {
    ShrineTheme {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    Log.i("cart", "CartItem: ${item.id}")
                },
                Modifier.padding(horizontal = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.RemoveCircleOutline,
                    contentDescription = "Remove item icon"
                )
            }

            Column(modifier = Modifier.fillMaxWidth()) {
                Divider(color = MaterialTheme.colors.onSecondary.copy(0.3f))
                Row(
                    Modifier.padding(vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(80.dp),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = item.photoResId),
                        contentDescription = "Image item"
                    )
                    Spacer(modifier = Modifier.width(24.dp))

                    Column(modifier = Modifier.padding(end = 16.dp)) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${item.vendor}".uppercase(),
                                style = MaterialTheme.typography.body2
                            )
                            Text(
                                text = "${item.price} $".uppercase(),
                                style = MaterialTheme.typography.body2
                            )
                        }
                        Text(
                            text = "${item.title}",
                            style = MaterialTheme.typography.subtitle2
                        )
                    }
                }
            }
        }
    }
}