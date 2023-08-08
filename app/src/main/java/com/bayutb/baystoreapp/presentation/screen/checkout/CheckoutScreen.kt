package com.bayutb.baystoreapp.presentation.screen.checkout

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.bayutb.baystoreapp.presentation.screen.TitleText
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckOutScreen(
    modifier: Modifier = Modifier,
    gameId: Int,
    checkOutViewModel: CheckOutViewModel = hiltViewModel()
) {
    val paymentMethods = checkOutViewModel.paymentMethods
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("Payment method") }
    var selectedLogo by remember { mutableStateOf("") }
    var isAccountChecked by remember { mutableStateOf(false) }
    val imageUrl =
        "https://yt3.googleusercontent.com/JnmzP-Ti7W8hygyWSLzJqoLkDLbhuQ2BEGNlq-pMmK8S_CjJhqzDr0D32QSMk-HZriAKh_dlsg=s900-c-k-c0x00ffffff-no-rj"
    Scaffold(
        topBar = { Topbar(imageUrl = imageUrl) },
        bottomBar = { BottomBar(price = 150000, selectedIndex = 1) }
    ) { paddingValues ->
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
                    model = imageUrl, contentDescription = "",
                    modifier
                        .size(100.dp)
                        .clip(
                            RoundedCornerShape(4.dp)
                        )
                )
                Column(
                    modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text(text = "PUBG MOBILE")
                    Text(text = "UC", fontSize = MaterialTheme.typography.bodySmall.fontSize)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            model = "https://www.vhv.rs/dpng/d/17-179454_pubg-uc-png-transparent-png.png",
                            contentDescription = "",
                            modifier
                                .size(16.dp)
                                .padding(end = 4.dp)
                        )
                        Text(
                            text = "744 + 101",
                            fontStyle = FontStyle.Italic,
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize
                        )
                    }
                }
                Text(text = "Rp. 150.000", fontWeight = FontWeight.Bold)
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
                            .padding(24.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier.weight(0.7f),
                            shape = RoundedCornerShape(32),
                            singleLine = true,
                            placeholder = { Text(text = "User ID") }
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier.weight(0.3f),
                            shape = RoundedCornerShape(32),
                            singleLine = true,
                            placeholder = { Text(text = "Server") }
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { isAccountChecked = true },
                        modifier = modifier.fillMaxWidth()
                    ) {
                        Text(text = "Check Account")
                    }
                }
            }
            AnimatedVisibility(visible = isAccountChecked) {
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
                        modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
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
                            Text(text = "RRQ GGGG")
                            Text(text = "60")
                        }
                    }
                }

            }
            AnimatedVisibility(visible = isAccountChecked, modifier.padding(horizontal = 16.dp)) {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
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
                        })
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        paymentMethods.onEach {
                            DropdownMenuItem(
                                leadingIcon = {
                                    AsyncImage(
                                        model = it.logo,
                                        contentDescription = it.name,
                                        modifier = modifier.size(16.dp)
                                    )
                                },
                                text = { Text(text = it.name) },
                                onClick = {
                                    text = it.name
                                    selectedLogo = it.logo
                                    expanded = false
                                    Toast.makeText(
                                        context,
                                        "${it.name} selected",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                            )
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
        CheckOutScreen(gameId = 1)
    }
}