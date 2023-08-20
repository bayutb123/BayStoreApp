package com.bayutb.baystoreapp.presentation.screen.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import com.bayutb.baystoreapp.domain.model.PaymentMethod
import com.bayutb.baystoreapp.domain.model.UserIGN
import com.bayutb.baystoreapp.presentation.screen.convertToRupiah

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    price: Int,
    paymentSelected: Int,
    account: UserIGN,
    onCheckOut: () -> Unit
) {

    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Column(modifier = modifier.weight(1f), horizontalAlignment = Alignment.End) {
                Text(text = convertToRupiah(price), fontWeight = FontWeight.Bold)
                Text(
                    text = "VAT 11% Included",
                    fontStyle = FontStyle.Italic,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            }
            Button(onClick = {
                onCheckOut()
            }, enabled = account.inGameNickName != "" && paymentSelected > 0) {
                Text(text = "Checkout")
            }
        }
    }

}