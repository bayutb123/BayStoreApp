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
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.presentation.components.TitleText
import com.bayutb.baystoreapp.presentation.components.home.BottomBar
import com.bayutb.baystoreapp.presentation.components.home.ColumnHolder
import com.bayutb.baystoreapp.presentation.components.home.GridHolder
import com.bayutb.baystoreapp.presentation.components.home.TopBar
import kotlinx.coroutines.flow.flow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
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
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
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
                val context = LocalContext.current
                var expanded by remember { mutableStateOf(false) }
                var text by remember {
                    mutableStateOf("Category")
                }
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    TextField(
                        readOnly = true,
                        value = text,
                        onValueChange = {},
                        modifier = modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        })
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        repeat(10) {
                            DropdownMenuItem(
                                text = { Text(text = "Category $it") },
                                onClick = {
                                    text = "Category $it"
                                    expanded = false
                                    Toast.makeText(context, "Category $it", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            )
                        }
                    }
                }

                LazyColumn(contentPadding = PaddingValues(vertical = 16.dp),
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

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun PvHomeScreen() {
    HomeScreen(homeViewModel = hiltViewModel(), onItemClick = {})
}