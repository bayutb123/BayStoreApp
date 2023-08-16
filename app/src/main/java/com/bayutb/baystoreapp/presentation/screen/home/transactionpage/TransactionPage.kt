package com.bayutb.baystoreapp.presentation.screen.home.transactionpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.bayutb.baystoreapp.presentation.screen.convertToRupiah
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionPage(
    modifier: Modifier = Modifier
) {
    val transactionViewModel :TransactionViewModel = hiltViewModel()
    val transactions = transactionViewModel.transactions
    var isSortVisible by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Transaction history") },
                actions = {
                    Box(modifier=  modifier) {
                        IconButton(onClick = { isSortVisible = !isSortVisible }) {
                            Icon(imageVector = Icons.Default.Sort, contentDescription = "Sort")
                        }
                        DropdownMenu(expanded = isSortVisible, onDismissRequest = {
                            isSortVisible = !isSortVisible
                        }) {
                            DropdownMenuItem(
                                text = {
                                    Text(text = "Ascending")
                                },
                                onClick = { isSortVisible = !isSortVisible }
                            )
                            DropdownMenuItem(
                                text = {
                                    Text(text = "Descending")
                                },
                                onClick = { isSortVisible = !isSortVisible }
                            )
                        }
                    }
                }
            )

        }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues),
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                content = {

                    items(transactions) {order ->
                        Card(shape = MaterialTheme.shapes.medium) {
                            Column(
                                modifier = modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    AsyncImage(
                                        model = "https://static.wikia.nocookie.net/gensin-impact/images/8/80/Genshin_Impact.png/revision/latest/scale-to-width-down/350?cb=20230121174225",
                                        contentDescription = null,
                                        modifier = modifier
                                            .size(50.dp)
                                            .clip(RoundedCornerShape(MaterialTheme.shapes.small.topStart))
                                    )
                                    Column(
                                        modifier
                                            .weight(0.6f)
                                            .padding(horizontal = 8.dp)
                                    ) {
                                        Text(
                                            text = order.date,
                                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                                        )
                                        Text(
                                            text = "Genshin Impact",
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = MaterialTheme.typography.bodyMedium.fontSize
                                        )
                                        Text(
                                            text = "374 diamonds",
                                            fontSize = MaterialTheme.typography.bodySmall.fontSize
                                        )
                                    }
                                    Text(
                                        text = convertToRupiah(order.itemPrice),
                                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.End,
                                        modifier = modifier.weight(0.3f)
                                    )
                                }
                            }
                        }
                    }

                }
            )
        }

    }
}

@Preview
@Composable
fun PreviewTransList() {
    BayStoreAppTheme {
        TransactionPage()
    }
}