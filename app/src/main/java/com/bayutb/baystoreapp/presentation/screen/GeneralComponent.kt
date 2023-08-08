package com.bayutb.baystoreapp.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    value: String,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    Text(
        text = value, fontWeight = FontWeight.ExtraBold,
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        modifier = modifier.padding(horizontal = 16.dp),
        color = color
    )
}