package com.bayutb.baystoreapp.presentation.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bayutb.baystoreapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    // BANNER
    Box(modifier.height(120.dp)) {

        Image(
            painter = painterResource(id = R.drawable.top_banner), contentDescription = null,
            contentScale = ContentScale.Crop, modifier = modifier.fillMaxSize(), colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary, BlendMode.Color)
        )
        Row(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(36.dp),
                value = "",
                onValueChange = {},
                maxLines = 1,
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                },
                modifier = modifier.weight(1f),
                placeholder = { Text(text = "Search ...") }
            )
            Image(
                modifier = modifier
                    .background(
                        MaterialTheme.colorScheme.primaryContainer,
                        shape = CircleShape
                    )
                    .padding(12.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                imageVector = Icons.Default.Person, contentDescription = "Profile"
            )
        }

    }
}