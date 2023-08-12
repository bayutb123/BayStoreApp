package com.bayutb.baystoreapp.presentation.screen.home.settingpage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun SettingItem(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit,
    icon: ImageVector
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }.padding(16.dp)
            ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = name
        )
        Text(text = name)
    }
    Divider(
        modifier = modifier.padding(bottom = 8.dp),
        thickness = 0.5.dp,
        color = MaterialTheme.colorScheme.outline
    )
}