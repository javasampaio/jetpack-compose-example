package com.example.composeexample.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composeexample.navigation.NavigationRoute

@Composable
fun DefaultBottomBar(navController: NavHostController) {
    val selectedState = remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    BottomNavigation(elevation = 10.dp) {
        BottomNavigationItem(
            selected = (selectedState.value == 0),
            onClick = { selectedState.value = 0 },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home") }
        )
        BottomNavigationItem(
            selected = (selectedState.value == 1),
            onClick = {
                selectedState.value = 1
                //context.startActivity(Intent(context, ListActivity::class.java))
                navController.navigate(NavigationRoute.LIST_VIEW)
            },
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorite") },
            label = { Text(text = "Favorite") }
        )
        BottomNavigationItem(
            selected = (selectedState.value == 2),
            onClick = { selectedState.value = 2 },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text(text = "Profile") }
        )
    }

}