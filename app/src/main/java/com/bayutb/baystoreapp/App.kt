package com.bayutb.baystoreapp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bayutb.baystoreapp.presentation.screen.Screen
import com.bayutb.baystoreapp.presentation.screen.catalog.CatalogScreen
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
                navController.navigate("${Screen.Catalog.route}/$it")
            })
        }
        composable(
            "${Screen.Catalog.route}/{gameId}",
            arguments = listOf(navArgument("gameId") {
                type = NavType.IntType
            })
        ) {
            val gameId = it.arguments?.getInt("gameId")
                CatalogScreen(
                    onBackClick = {
                        navController.navigateUp()
                    }, gameId = gameId ?: 0
                )
        }
    }
}