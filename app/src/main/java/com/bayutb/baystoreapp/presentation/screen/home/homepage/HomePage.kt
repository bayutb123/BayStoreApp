package com.bayutb.baystoreapp.presentation.screen.home.homepage

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bayutb.baystoreapp.presentation.screen.TitleText
import com.bayutb.baystoreapp.presentation.screen.home.HomeViewModel
import com.bayutb.baystoreapp.presentation.screen.home.components.BottomBar
import com.bayutb.baystoreapp.presentation.screen.home.components.ColumnHolder
import com.bayutb.baystoreapp.presentation.screen.home.components.GridHolder
import com.bayutb.baystoreapp.presentation.screen.home.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val gamesState = homeViewModel.games.value
    val hotGamesState = homeViewModel.hotGames.value

    // TEMPORARY
    val allGames = homeViewModel.allGames
    val allHotGames = homeViewModel.allHotGames

    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // HOT GAME
            Column(modifier = modifier.padding(bottom = 8.dp)) {
                TitleText(value = "Hot Games")
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(allHotGames) {
                            GridHolder(
                                game = it,
                                modifier = modifier.clickable { onItemClick(it.id) },
                            )
                        }
                    }
                )
            }
            // GAME LIST
            Column(
                modifier = modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {


                LazyColumn(contentPadding = PaddingValues(bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp), content = {
                        items(allGames) {
                            ColumnHolder(
                                modifier.clickable { onItemClick(it.id) },
                                game = it
                            )
                            if (it.popularity > 50) {
                                Log.d("HomeScreen", it.name)
                            }
                        }
                    })
            }
        }
    }

}