package com.example.composeexample.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun DefaultScaffold(
    topBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
    bottomBar: @Composable() (() -> Unit)? = null
    ) {
    if (bottomBar != null) {
        Scaffold(
            topBar = topBar,
            content = content,
            bottomBar = bottomBar
        )
        return
    }
    Scaffold(
        topBar = topBar,
        content = content
    )
}