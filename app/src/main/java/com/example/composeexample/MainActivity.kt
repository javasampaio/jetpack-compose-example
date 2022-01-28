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
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeexample.components.DefaultBottomBar
import com.example.composeexample.components.DefaultScaffold
import com.example.composeexample.components.DefaultToolbar
import com.example.composeexample.navigation.NavigationArgsNames
import com.example.composeexample.navigation.NavigationRoute
import com.example.composeexample.ui.theme.ComposeExampleTheme
import com.example.composeexample.views.DetailsView
import com.example.composeexample.views.ListView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                //MainView()
                NavController()
            }
        }
    }
}

@Composable
fun NavController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoute.HOME) {
        composable(NavigationRoute.HOME) { MainView(navController) }
        composable(NavigationRoute.LIST_VIEW) {
            ListView(navigationCallback = {
                navController.popBackStack()
            },
            onItemClick = {
                navController.navigate(NavigationRoute.getDetailsRoute(it))
            })
        }
        composable(
            NavigationRoute.DETAILS_VIEW,
            arguments = listOf(navArgument(NavigationArgsNames.MESSAGE) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val message = backStackEntry.arguments?.getString(NavigationArgsNames.MESSAGE)
            DetailsView(
                navController,
                message?.toObject()
            )
        }
    }
}

@Composable
fun MainView(navController: NavHostController) {
    DefaultScaffold(
        topBar = {
            DefaultToolbar(
                name = "Compose",
                dropMenuItems = getDropMenuItems(),
                hasBackButton = false
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
            DefaultBottomBar(navController)
        },
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