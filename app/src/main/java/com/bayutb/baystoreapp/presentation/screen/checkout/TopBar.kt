package com.bayutb.baystoreapp.presentation.screen.checkout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Topbar(
    modifier: Modifier = Modifier,
    imageUrl: String,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier
            .fillMaxWidth()
            .height(75.dp),
        contentScale = ContentScale.Crop
    )
}