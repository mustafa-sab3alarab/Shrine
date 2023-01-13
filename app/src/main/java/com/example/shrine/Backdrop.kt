package com.example.shrine

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shrine.ui.theme.ShrineTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BackDrop() {

    val scope = rememberCoroutineScope()

    val backdropScaffoldState =
        rememberBackdropScaffoldState(BackdropValue.Revealed)

    BackdropScaffold(
        appBar = {
            TopAppBar(scope, backdropScaffoldState)
        },
        scaffoldState = backdropScaffoldState,
        frontLayerContent = {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(MaterialTheme.colors.surface),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Hello", style = MaterialTheme.typography.body1)
            }
        },
        frontLayerShape = MaterialTheme.shapes.large,
        backLayerContent = {
            Column(
                Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MenuItems("Featured")
                MenuItems("Apartment")
                MenuItems("Accessories")
                MenuItems("Shoes")
                MenuItems("Tops")
                MenuItems("Bottoms")
                MenuItems("Dresses")
                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .width(56.dp),
                    color = MaterialTheme.colors.onBackground
                )
                MenuItems("My Account", modifier = Modifier.alpha(0.4f))
            }
        }
    )
}

@Composable
fun MenuItems(text: String = "Menu Item", modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text.uppercase(), style = MaterialTheme.typography.subtitle1
    )
}

@ExperimentalMaterialApi
@Composable
private fun TopAppBar(
    scope: CoroutineScope,
    backdropScaffoldState: BackdropScaffoldState
) {
    TopAppBar(
        elevation = 0.dp,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = {
                        scope.launch {
                            Log.i("BackDrop", "TopAppBar: ${Thread.currentThread().name}")
                            when {
                                backdropScaffoldState.isConcealed -> backdropScaffoldState.reveal()
                                else -> backdropScaffoldState.conceal()
                            }
                        }
                    },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu_cut_24px),
                        contentDescription = "menu"
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.shrine_logo),
                    contentDescription = "shrine logo"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    stringResource(id = R.string.app_name).uppercase(),
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = 17.sp
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primary,

        actions = {
            Icon(
                modifier = Modifier.padding(end = 16.dp),
                imageVector = Icons.Filled.Search,
                contentDescription = "Search icon"
            )
        })
}

@ExperimentalMaterialApi
@Composable
@DevicePreviews
fun BackDropTest() {
    ShrineTheme {
        BackDrop()
    }
}


@ExperimentalMaterialApi
@DevicePreviews
@Composable
fun TopAppBarTest() {
    ShrineTheme {
        TopAppBar(
            rememberCoroutineScope(), rememberBackdropScaffoldState(BackdropValue.Concealed)
        )
    }
}