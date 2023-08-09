package com.bayutb.baystoreapp.presentation.screen.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.HistoryToggleOff
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bayutb.baystoreapp.presentation.screen.home.IconState
import com.bayutb.baystoreapp.presentation.screen.home.NavigationBarItem

@Composable
fun BottomBar(
    navController: NavController
) {
    var selectedItem by remember {
        mutableStateOf(0)
    }
    val navItem: List<NavigationBarItem> = listOf(
        NavigationBarItem(
            id = 1, label = "Home", route = "home_page", selected = false, icon = IconState(
                active = Icons.Filled.Home, inactive = Icons.Outlined.Home
            )
        ), NavigationBarItem(
            id = 2,
            label = "Transaction",
            route = "transaction_page",
            selected = false,
            icon = IconState(
                active = Icons.Filled.History, inactive = Icons.Outlined.HistoryToggleOff
            )
        ), NavigationBarItem(
            id = 3, label = "Setting", route = "setting_page", selected = false, icon = IconState(
                active = Icons.Filled.Settings, inactive = Icons.Outlined.Settings
            )
        )
    )
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        navItem.forEachIndexed { index, _ ->
            NavigationBarItem(selected = currentDestination?.hierarchy?.any { it.route == navItem[index].route } == true,
                onClick = {
                    selectedItem = index
                    navController.navigate(navItem[index].route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    AnimatedVisibility(visible = currentDestination?.hierarchy?.any { it.route == navItem[index].route } == true,
                        exit = shrinkHorizontally(shrinkTowards = Alignment.Start),
                        enter = expandHorizontally()) {
                        Icon(
                            navItem[index].icon.active, contentDescription = navItem[index].label
                        )
                    }
                    AnimatedVisibility(visible = currentDestination?.hierarchy?.any { it.route == navItem[index].route } == false,
                        exit = shrinkHorizontally(shrinkTowards = Alignment.Start),
                        enter = expandHorizontally()) {
                        Icon(
                            navItem[index].icon.inactive, contentDescription = navItem[index].label
                        )
                    }

                },
                label = { Text(text = "${navItem[index].label}", fontSize = 12.sp) })
        }

    }
}
