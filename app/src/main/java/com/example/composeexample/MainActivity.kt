package com.example.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeexample.components.DefaultBottomBar
import com.example.composeexample.components.DefaultScaffold
import com.example.composeexample.components.DefaultToolbar
import com.example.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                MainView()
            }
        }
    }
}

@Composable
fun MainView() {
    DefaultScaffold(
        topBar = {
            DefaultToolbar(
                name = "Compose",
                dropMenuItems = getDropMenuItems()
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.compose),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
            }
        },
        bottomBar = {
            DefaultBottomBar()
        }
    )
}

fun getDropMenuItems(): @Composable ((ColumnScope) -> Unit) = @Composable {
    DropdownMenuItem(onClick = { }, modifier = Modifier.fillMaxWidth()) {
        Icon(Icons.Filled.Settings, contentDescription = "")
        Text(text = "Settings")
    }
    DropdownMenuItem(onClick = { }) {
        Icon(Icons.Filled.Email, contentDescription = "")
        Text(text = "Add cart")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme {
        MainView()
    }
}