package com.bayutb.baystoreapp

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices.PIXEL_4_XL
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bayutb.baystoreapp.presentation.Screen
import com.bayutb.baystoreapp.presentation.screen.catalog.CatalogScreen
import com.bayutb.baystoreapp.presentation.screen.checkout.CheckOutScreen
import com.bayutb.baystoreapp.presentation.screen.home.HomeScreen
import com.bayutb.baystoreapp.presentation.screen.login.LoginScreen
import com.bayutb.baystoreapp.presentation.screen.payment.PaymentScreen
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
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
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
                    navController.navigate("${Screen.Checkout.route}/${inGameCurrency.id}/${inGameCurrency.gameId}")
                }, gameId = gameId ?: 0
            )
        }
        composable(
            "${Screen.Checkout.route}/{inGameCurrencyId}/{gameId}",
            arguments = listOf(
                navArgument("inGameCurrencyId") { type = NavType.IntType },
                navArgument("gameId") { type = NavType.IntType }
            )
        ) { it ->
            val itemId = it.arguments?.getInt("inGameCurrencyId")
            val gameId = it.arguments?.getInt("gameId")
            CheckOutScreen(itemId = itemId ?: 0, gameId = gameId ?: 0) { order ->
                navController.navigate("${Screen.Payment.route}/${order.account.id}/${order.inGameCurrency.id}/${order.paymentMethod.id}")
            }
        }
        composable("${Screen.Payment.route}/{accountId}/{itemId}/{paymentId}",
            arguments = listOf(
                navArgument("accountId") { type = NavType.IntType },
                navArgument("itemId") { type = NavType.IntType },
                navArgument("paymentId") { type = NavType.IntType }
            )) {
            val accountId = it.arguments?.getInt("accountId")
            val itemId = it.arguments?.getInt("itemId")
            val paymentId = it.arguments?.getInt("paymentId")
            PaymentScreen(
                accountId = accountId ?: 0,
                itemId = itemId ?: 0,
                paymentId = paymentId ?: 0
            ) {
                navController.popBackStack(
                    Screen.Home.route,
                    inclusive = false,
                    saveState = false
                )
            }
        }
    }
}

