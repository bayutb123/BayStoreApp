package com.bayutb.baystoreapp.presentation.screen.checkout

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.OrderDetail
import com.bayutb.baystoreapp.presentation.screen.TitleText
import com.bayutb.baystoreapp.presentation.screen.convertToRupiah
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutScreen(
    modifier: Modifier = Modifier,
    itemId: Int,
    gameId: Int,
    checkOutViewModel: CheckOutViewModel = hiltViewModel(),
    onCheckOut: (OrderDetail) -> Unit
) {
    val context = LocalContext.current
    // STATE
    val defaultUser = GameAccount(0, "User not found~~", 0, 0)
    var user by remember { mutableStateOf(defaultUser) }
    var userId by remember { mutableStateOf("") }
    var userServer by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("Payment method") }
    var selectedLogo by remember { mutableStateOf("") }
    var paymentSelectedIndex by remember { mutableStateOf(0) }
    Log.d("Payment Selected", paymentSelectedIndex.toString())
    var expanded by remember { mutableStateOf(false) }
    var isAccountChecked by remember { mutableStateOf(false) }

    // VIEWMODEL
    val item = checkOutViewModel.getItemCurrencyById(itemId, gameId)
    val paymentMethods = checkOutViewModel.paymentMethods

    Scaffold(topBar = { Topbar(imageUrl = item.game.imageUrl) }, bottomBar = {
        BottomBar(
            price = item.item.price,
            account = user,
            paymentSelected = paymentSelectedIndex,
            onCheckOut = {
                val orderDetail = OrderDetail(
                    user,
                    item.item,
                    paymentMethods[paymentSelectedIndex - 1],
                    null
                )
                onCheckOut(orderDetail)
            }
        )
    }) { paddingValues ->
        Column(
            modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            TitleText(value = "Item cart", modifier = modifier.padding(vertical = 8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = modifier.padding(horizontal = 16.dp)
            ) {
                AsyncImage(
                    model = item.game.imageUrl,
                    contentDescription = null,
                    modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
                Column(
                    modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text(text = item.game.name)
                    Text(
                        text = item.item.name,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            model = item.item.iconUrl,
                            contentDescription = "",
                            modifier
                                .size(16.dp)
                                .padding(end = 4.dp)
                        )
                        Text(
                            text = "${item.item.baseCount} + ${item.item.bonusItem}",
                            fontStyle = FontStyle.Italic,
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize
                        )
                    }
                }
                Text(text = convertToRupiah(item.item.price), fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = modifier
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(24.dp)
                            )
                            .padding(24.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = userId,
                            onValueChange = { userId = it },
                            modifier.weight(0.7f),
                            shape = RoundedCornerShape(32),
                            singleLine = true,
                            placeholder = { Text(text = "User ID") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        )
                        OutlinedTextField(
                            value = userServer,
                            onValueChange = { userServer = it },
                            modifier.weight(0.3f),
                            shape = RoundedCornerShape(32),
                            singleLine = true,
                            placeholder = { Text(text = "Server") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            user = checkOutViewModel.getAccountById(
                                id = userId, server = userServer
                            ) ?: defaultUser
                            isAccountChecked = true
                        }, modifier = modifier.fillMaxWidth()
                    ) {
                        Text(text = "Check Account")
                    }
                }
            }
            AnimatedVisibility(visible = user.id == 0) {
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(
                            color = MaterialTheme.colorScheme.errorContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                ) {
                    Text(text = "Acount Information", fontWeight = FontWeight.Bold)
                    Box(
                        modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(text = if (isAccountChecked) {
                                "Account not found!"
                            } else {
                                "Input your username id and server"
                            })
                        }
                    }
                }
            }
            AnimatedVisibility(visible = user.id != 0) {
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                ) {
                    Text(text = "Acount Information", fontWeight = FontWeight.Bold)

                    Row(
                        modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column {
                            Text(text = "Account name")
                            Text(text = "Level")
                        }
                        Spacer(modifier = modifier.width(8.dp))
                        Column {
                            Text(text = ":")
                            Text(text = ":")
                        }
                        Column(Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                            Text(text = user.name)
                            Text(text = "${user.level}")
                        }
                    }
                }
            }
            AnimatedVisibility(visible = user.id != 0, modifier.padding(horizontal = 16.dp)) {
                ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
                    expanded = !expanded
                }) {
                    TextField(
                        leadingIcon = {
                            AsyncImage(
                                model = selectedLogo,
                                contentDescription = null,
                                modifier = modifier.size(16.dp)
                            )
                        },
                        readOnly = true,
                        value = text,
                        onValueChange = {},
                        modifier = modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedIndicatorColor = MaterialTheme.colorScheme.surface,
                            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface
                        )
                    )
                    ExposedDropdownMenu(expanded = expanded,
                        onDismissRequest = { expanded = false }) {
                        paymentMethods.onEach {
                            DropdownMenuItem(leadingIcon = {
                                AsyncImage(
                                    model = it.logo,
                                    contentDescription = it.name,
                                    modifier = modifier.size(16.dp)
                                )
                            }, text = { Text(text = it.name) }, onClick = {
                                text = it.name
                                selectedLogo = it.logo
                                expanded = false
                                paymentSelectedIndex = it.id
                                Toast.makeText(
                                    context, "${it.name} selected", Toast.LENGTH_SHORT
                                ).show()
                            })
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    BayStoreAppTheme {
        CheckOutScreen(itemId = 1, gameId = 1) {

        }
    }
}