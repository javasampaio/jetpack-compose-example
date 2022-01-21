package com.example.composeexample.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composeexample.components.DefaultScaffold
import com.example.composeexample.components.DefaultToolbar
import com.example.composeexample.model.Message
import com.example.composeexample.ui.theme.dimen12Dp

@Composable
fun DetailsView(navController: NavHostController, message: Message?) {
    DefaultScaffold(
        topBar = {
            DefaultToolbar(
                name = "Details",
                navigationCallback = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            Column() {
                message?.let {
                    Text(text = it.author, Modifier.padding(dimen12Dp))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = it.message, Modifier.padding(dimen12Dp))
                }
            }

        }
    )
}