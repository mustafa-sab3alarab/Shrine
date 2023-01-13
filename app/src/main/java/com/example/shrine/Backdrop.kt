package com.example.shrine

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shrine.ui.theme.ShrineTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BackDrop() {

    val scope = rememberCoroutineScope()

    val backdropScaffoldState =
        rememberBackdropScaffoldState(BackdropValue.Concealed)

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
                    .background(MaterialTheme.colors.primary),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Alpha", style = MaterialTheme.typography.subtitle2)
            }
        }
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
                    style = MaterialTheme.typography.subtitle1
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
@Preview
@Composable
fun BackDropTest() {
    ShrineTheme {
        BackDrop()
    }
}


@ExperimentalMaterialApi
@Preview
@Composable
fun TopAppBarTest() {
    ShrineTheme {
        TopAppBar(
            rememberCoroutineScope(), rememberBackdropScaffoldState(BackdropValue.Concealed)
        )
    }
}