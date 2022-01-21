package com.example.composeexample.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomExtededFAB(
    callback: () -> Unit,
    contentAlignment: Alignment = Alignment.BottomEnd
) {
    Box(contentAlignment = contentAlignment, modifier = Modifier.fillMaxWidth()) {
        ExtendedFloatingActionButton(
            text = { Text(text = "Add") },
            onClick = { callback.invoke() },
            modifier = Modifier.padding(12.dp),
            icon = { Icon(Icons.Filled.Add, contentDescription = "") }
        )
    }
}