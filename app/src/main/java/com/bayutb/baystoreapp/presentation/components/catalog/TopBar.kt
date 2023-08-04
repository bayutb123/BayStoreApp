package com.bayutb.baystoreapp.presentation.components.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bayutb.baystoreapp.R

@Composable
fun Topbar(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.banner_catalog),
        contentDescription = null,
        modifier
            .fillMaxWidth()
            .height(75.dp),
        contentScale = ContentScale.Crop
    )
}