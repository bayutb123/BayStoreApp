package com.bayutb.baystoreapp.presentation.screen.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bayutb.baystoreapp.presentation.screen.TitleText
import com.bayutb.baystoreapp.presentation.screen.home.components.BottomBar
import com.bayutb.baystoreapp.presentation.screen.home.components.ColumnHolder
import com.bayutb.baystoreapp.presentation.screen.home.components.GridHolder
import com.bayutb.baystoreapp.presentation.screen.home.components.TopBar
import com.bayutb.baystoreapp.presentation.screen.home.homepage.HomePage
import com.bayutb.baystoreapp.presentation.screen.home.settingpage.SettingPage
import com.bayutb.baystoreapp.presentation.screen.home.transactionpage.TransactionPage

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
            composable("setting_page") {
                SettingPage()
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun PvHomeScreen() {

}