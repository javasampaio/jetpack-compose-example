package com.example.composeexample.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun DefaultToolbar(
    name: String = "",
    hasBackButton: Boolean = true,
    navigationCallback: (() -> Unit)? = null,
    dropMenuItems: @Composable ((ColumnScope) -> Unit)? = null
) {
    var showMenu by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = { Text(text = name) },
        navigationIcon = {
            if (hasBackButton) {
                IconButton(onClick = { navigationCallback?.invoke() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "")
                }
            }
        },
        elevation = AppBarDefaults.TopAppBarElevation,
        actions = {
            dropMenuItems?.let {
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(Icons.Filled.Menu, contentDescription = "")
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false },
                    content = it,
                )
            }
        }
    )
}