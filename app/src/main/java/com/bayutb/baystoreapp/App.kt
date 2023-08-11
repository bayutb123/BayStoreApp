package com.bayutb.baystoreapp

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4_XL
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bayutb.baystoreapp.presentation.Screen
import com.bayutb.baystoreapp.presentation.screen.catalog.CatalogScreen
import com.bayutb.baystoreapp.presentation.screen.checkout.CheckOutScreen
import com.bayutb.baystoreapp.presentation.screen.home.HomeScreen
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme

@Composable
fun App() {
    NavController()
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(onHomeItemClicked = {
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
                onCheckOut = { inGameCurrency ->
                    navController.navigate("${Screen.Checkout.route}/${inGameCurrency.id}")
                }, gameId = gameId ?: 0
            )
        }
        composable(
            "${Screen.Checkout.route}/{inGameCurrencyId}",
            arguments = listOf(navArgument("inGameCurrencyId") {
                type = NavType.IntType
            })
        ) {
            val gameId = it.arguments?.getInt("inGameCurrencyId")
            CheckOutScreen(gameId = gameId ?: 0)
        }
    }
}

