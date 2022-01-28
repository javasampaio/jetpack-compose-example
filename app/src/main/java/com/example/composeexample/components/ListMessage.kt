package com.example.composeexample.components

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
import com.example.composeexample.R
import com.example.composeexample.model.Message
import com.example.composeexample.ui.theme.dimen12Dp
import com.example.composeexample.ui.theme.dimen1point5Dp
import com.example.composeexample.ui.theme.dimen40Dp
import com.example.composeexample.ui.theme.dimen8Dp

@Composable
fun ListCardMessage(
    messages: LiveData<List<Message>>,
    onItemClick: ((message: Message) -> Unit)? = null
) {
    val messageState = messages.observeAsState(listOf())

    messageState.value.let {
        LazyColumn {
            items(it) { message ->
                CardMessage(message = message, onItemClick = onItemClick)
                //MessageCard(message)
            }
        }
    }
}


@Composable
fun CardMessage(message: Message, onItemClick: ((message: Message) -> Unit)? = null) {
    Row(modifier = Modifier
        .padding(all = dimen12Dp)
        .clickable {
            onItemClick?.invoke(message)
        }) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(dimen40Dp)
                .clip(CircleShape)
                .border(dimen1point5Dp, MaterialTheme.colors.secondaryVariant, CircleShape)

        )

        Spacer(modifier = Modifier.width(dimen8Dp))

        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))


            Text(
                text = message.message,
                modifier = Modifier
                    .padding(all = 4.dp)
                    .fillMaxWidth(),
                maxLines = 3,
                style = MaterialTheme.typography.body2
            )
        }
    }
}