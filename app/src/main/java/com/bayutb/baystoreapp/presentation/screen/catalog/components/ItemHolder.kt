package com.bayutb.baystoreapp.presentation.screen.catalog.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bayutb.baystoreapp.ui.theme.BayStoreAppTheme

@Composable
fun ItemHolder(
    modifier: Modifier = Modifier,
    baseItem: Int,
    bonusItem: Int?,
    itemName: String,
    iconUrl: String,
    isSelected: Boolean = false
) {
    var containerColor = MaterialTheme.colorScheme.surface
    var contentColor = MaterialTheme.colorScheme.onSurface
    if (isSelected) {
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer
        contentColor = MaterialTheme.colorScheme.primaryContainer
    } else {
        containerColor = MaterialTheme.colorScheme.surface
        contentColor = MaterialTheme.colorScheme.onSurface
    }
    Box(
        modifier = modifier.background(
            shape = RoundedCornerShape(8.dp), color = containerColor
        )
    ) {
        Column(modifier.padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                AsyncImage(model = iconUrl, contentDescription = null, modifier = modifier.size(20.dp))
                Text(
                    text = "${
                        if (bonusItem != null) {
                            bonusItem + baseItem
                        } else {
                            baseItem
                        }
                    }", fontSize = MaterialTheme.typography.bodyLarge.fontSize, color = contentColor
                )
            }
            Text(
                text = "$baseItem ${if (bonusItem != null) { "+ $bonusItem" } else {
                    ""
                }
                } $itemName",
                fontStyle = FontStyle.Italic,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                color = contentColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemHolder() {
    BayStoreAppTheme {

    }
}