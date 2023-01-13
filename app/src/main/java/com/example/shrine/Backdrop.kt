package com.example.shrine

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
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

private val menuData = listOf(
    "Featured",
    "Apartment",
    "Accessories",
    "Shoes",
    "Tops",
    "Bottoms",
    "Dresses"
)

@ExperimentalMaterialApi
@Composable
fun BackDrop() {

    val scope = rememberCoroutineScope()

    val backdropScaffoldState =
        rememberBackdropScaffoldState(BackdropValue.Concealed)

    var menuSelection by remember {
        mutableStateOf(0)
    }

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
                Text(
                    text = "This is the front layer to ${menuData[menuSelection]}",
                    style = MaterialTheme.typography.body1
                )
            }
        },
        frontLayerShape = MaterialTheme.shapes.large,
        backLayerContent = {
            BackDropLayer(
                activeMenuItem = menuSelection,
                onMenuItemSelect = { index ->
                    menuSelection = index
                    scope.launch {
                        backdropScaffoldState.conceal()
                    }
                }
            )
        }
    )
}

@Composable
private fun BackDropLayer(activeMenuItem: Int, onMenuItemSelect: (index: Int) -> Unit) {
    Column(
        Modifier
            .padding(32.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        menuData.forEachIndexed { index, item ->
            MenuItems(index = index, text = item, activeMenu = activeMenuItem) {
                onMenuItemSelect(index)
            }
        }

        Divider(
            modifier = Modifier
                .height(1.dp)
                .width(56.dp),
            color = MaterialTheme.colors.onBackground
        )

        MenuItems(
            text = "My Account",
            modifier = Modifier.alpha(0.4f),
            activeMenu = activeMenuItem
        ) {
            Log.d("BackDropLayer", "MenuItem: ${menuData.size}")
        }
    }
}

@Composable
fun MenuItems(
    index: Int = -1,
    text: String = "Menu Item",
    activeMenu: Int,
    modifier: Modifier = Modifier,
    onClick: (index: Int) -> Unit
) {
    Box(modifier = Modifier.height(20.dp), contentAlignment = Alignment.Center) {
        if (activeMenu == index) {
            Image(
                painter = painterResource(id = R.drawable.ic_tab_indicator),
                contentDescription = "tab indicator"
            )
        }

        Text(
            modifier = modifier.clickable {
                onClick(index)
            },
            text = text.uppercase(), style = MaterialTheme.typography.subtitle1
        )
    }

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