package com.example.composeexample.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.composeexample.ListViewModel
import com.example.composeexample.R
import com.example.composeexample.components.CustomExtededFAB
import com.example.composeexample.components.DefaultScaffold
import com.example.composeexample.components.DefaultToolbar
import com.example.composeexample.components.ListCardMessage
import com.example.composeexample.model.Message
import com.example.composeexample.navigation.NavigationRoute
import com.example.composeexample.ui.theme.dimen12Dp
import com.example.composeexample.ui.theme.dimen1point5Dp
import com.example.composeexample.ui.theme.dimen40Dp
import com.example.composeexample.ui.theme.dimen8Dp
import org.koin.androidx.compose.getViewModel

@Composable
fun ListView(
    navigationCallback: (() -> Unit)? = null,
    onItemClick: ((message: Message) -> Unit)? = null
) {
    val viewModel = getViewModel<ListViewModel>()
    DefaultScaffold(
        topBar = {
            DefaultToolbar(
                name = "Messages",
                navigationCallback = {
                    navigationCallback?.invoke()
                    //navController.popBackStack()
                }
            )
        },
        content = { ListCardMessage(messages = viewModel.messages, onItemClick = onItemClick) }
    ) {
        CustomExtededFAB(callback = { viewModel.addNewMessage() })
    }
}
