package com.bayutb.baystoreapp.presentation.screen.home.settingpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bayutb.baystoreapp.R
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme

@Composable
fun SettingPage(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                modifier
                    .height(250.dp)
                    .background(color = MaterialTheme.colorScheme.primary),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baystoreicon),
                    contentDescription = null,
                    modifier = modifier.size(150.dp)
                )
                Text(
                    text = "Bayu Tantra Bramandhita",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    lineHeight = 30.sp
                )
            }
            Column(modifier
                    .padding(top = 200.dp, end = 16.dp, start = 16.dp)) {
                Column(
                    modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        SettingItem(
                            name = "Bay Balance (Rp 14.000.000)",
                            onClick = { /*TODO*/ },
                            icon = Icons.Default.AccountBalanceWallet
                        )
                        SettingItem(
                            name = "Manage Payment Methods",
                            onClick = { /*TODO*/ },
                            icon = Icons.Default.Payments
                        )
                    }
                }
                Spacer(modifier = modifier.height(8.dp))
                Column(
                    modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        SettingItem(
                            name = "Account Setting",
                            onClick = { /*TODO*/ },
                            icon = Icons.Default.ManageAccounts
                        )
                    }
                }
                Spacer(modifier = modifier.height(8.dp))
                Column(
                    modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Column(
                        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        SettingItem(
                            name = "Customer Service",
                            onClick = { /*TODO*/ },
                            icon = Icons.Default.Message
                        )
                        SettingItem(
                            name = "FAQ",
                            onClick = { /*TODO*/ },
                            icon = Icons.Default.Help
                        )
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun PreviewSettings() {
    BayStoreAppTheme {
        SettingPage()
    }
}