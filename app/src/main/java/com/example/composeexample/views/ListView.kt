package com.example.composeexample.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.composeexample.ListViewModel
import com.example.composeexample.R
import com.example.composeexample.navigation.NavigationRoute
import com.example.composeexample.components.CustomExtededFAB
import com.example.composeexample.components.DefaultScaffold
import com.example.composeexample.components.DefaultToolbar
import com.example.composeexample.model.Message
import com.example.composeexample.ui.theme.dimen12Dp
import com.example.composeexample.ui.theme.dimen1HalfDp
import com.example.composeexample.ui.theme.dimen40Dp
import org.koin.androidx.compose.getViewModel

@Composable
fun ListView(navController: NavController) {
    val viewModel = getViewModel<ListViewModel>()
    DefaultScaffold(
        topBar = {
            DefaultToolbar(
                name = "Messages",
                navigationCallback = {
                    navController.popBackStack()
                }
            )
        },
        content = { Conversation(messages = viewModel.messages, navController = navController) }
    ) {
        CustomExtededFAB(callback = { viewModel.addNewMessage() })
    }
}

@Composable
fun Conversation(
    messages: LiveData<List<Message>>,
    navController: NavController
) {
    val messageState = messages.observeAsState(listOf())

    messageState.value.let {
        LazyColumn {
            items(it) { message ->
                ListCard(message = message, onItemClick = {
                    navController.navigate(NavigationRoute.getDetailsRoute(it))
                })
                //MessageCard(message)
            }
        }
    }
}

@Composable
fun ListCard(message: Message, onItemClick: ((message: Message) -> Unit)? = null) {
    Row(modifier = Modifier.padding(all = dimen12Dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(dimen40Dp)
                .clip(CircleShape)
                .border(dimen1HalfDp, MaterialTheme.colors.secondaryVariant)
                .clickable {
                    onItemClick?.invoke(message)
                }
        )

    }
}