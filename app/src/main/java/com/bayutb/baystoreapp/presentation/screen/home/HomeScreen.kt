package com.bayutb.baystoreapp.presentation.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bayutb.baystoreapp.presentation.screen.home.components.BottomBar
import com.bayutb.baystoreapp.presentation.screen.home.homepage.HomePage
import com.bayutb.baystoreapp.presentation.screen.home.settingpage.SettingPage
import com.bayutb.baystoreapp.presentation.screen.home.transactionpage.TransactionPage
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onHomeItemClicked: (Int) -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "home_page",
            modifier = modifier.padding(paddingValues)
        ) {
            composable("home_page") {
                HomePage(onItemClick = { onHomeItemClicked(it) })
            }
            composable("transaction_page") {
                TransactionPage()
            }
            composable("account_page") {
                SettingPage()
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun PvHomeScreen() {
    BayStoreAppTheme {
        HomeScreen(onHomeItemClicked = {

        })
    }
}