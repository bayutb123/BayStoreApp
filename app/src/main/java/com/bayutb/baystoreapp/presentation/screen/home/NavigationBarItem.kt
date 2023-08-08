package com.bayutb.baystoreapp.presentation.screen.home

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItem(
    val id: Int,
    val label: String,
    val route: String,
    val icon: IconState,
    val selected: Boolean
)

data class IconState(
    val active: ImageVector,
    val inactive: ImageVector
)
