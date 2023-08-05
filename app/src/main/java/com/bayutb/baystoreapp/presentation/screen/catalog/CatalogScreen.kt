package com.bayutb.baystoreapp.presentation.screen.catalog

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.bayutb.baystoreapp.R
import com.bayutb.baystoreapp.presentation.components.TitleText
import com.bayutb.baystoreapp.presentation.components.catalog.ItemHolder
import com.bayutb.baystoreapp.presentation.components.catalog.Topbar
import com.bayutb.baystoreapp.presentation.screen.Screen
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    modifier: Modifier = Modifier,
    onBackClick: (Int) -> Unit,
    gameId: Int,
    catalogViewModel: CatalogViewModel = hiltViewModel()
) {
    val items = catalogViewModel.getItemByGameId(gameId)
    val gameDetail = catalogViewModel.getGameDetailById(gameId)
    items.forEach {
        Log.d("CatalogScreen", "${it.name} from gameId = ${it.gameId} with total diamonds of ${it.baseCount + (it.bonusItem ?: 0)} LOADED SUCCESSFULLY!")
    }
    Scaffold(topBar = { Topbar(imageUrl = gameDetail.imageUrl)},
        bottomBar = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Column(modifier = modifier.weight(1f), horizontalAlignment = Alignment.End) {
                    Text(text = "Rp. 250.000", fontWeight = FontWeight.Bold)
                    Text(text = "VAT 11% Included", fontStyle = FontStyle.Italic, fontSize = MaterialTheme.typography.bodyMedium.fontSize)
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Checkout")
                }
            }
        }) { paddingValues ->
        Column(
            modifier
                .padding(paddingValues)
                .background(color = MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AsyncImage(model = gameDetail.imageUrl, contentDescription = gameDetail.name,
                        modifier.size(60.dp).clip(RoundedCornerShape(8.dp)))
                    Column {
                        Text(text = gameDetail.name, fontWeight = FontWeight.Bold)
                        Text(text = gameDetail.publisher)
                    }
                }
            }
            TitleText(
                value = "Catalog",
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = modifier.padding(vertical = 8.dp)
            )
            Column(modifier.padding(horizontal = 16.dp)) {
                val spacer = 8.dp
                LazyVerticalGrid(
                    contentPadding = PaddingValues(bottom = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(spacer),
                    verticalArrangement = Arrangement.spacedBy(spacer),
                    columns = GridCells.Fixed(2),
                    content = {
                        items(items = items) {
                            ItemHolder(
                                baseItem = it.baseCount,
                                bonusItem = it.bonusItem,
                                itemName = it.name,
                                iconUrl = it.iconUrl
                            )
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCatalogScreen() {
    BayStoreAppTheme {
    }
}