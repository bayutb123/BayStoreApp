package com.bayutb.baystoreapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bayutb.baystoreapp.presentation.screen.Screen
import com.bayutb.baystoreapp.presentation.screen.catalog.CatalogScren
import com.bayutb.baystoreapp.presentation.screen.home.HomeScreen

@Composable
fun App() {
    NavController()
}

@Composable
fun NavController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(onItemClick = {
                navController.navigate(Screen.Catalog.route)
            })
        }
        composable(Screen.Catalog.route) {
            CatalogScren(
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}