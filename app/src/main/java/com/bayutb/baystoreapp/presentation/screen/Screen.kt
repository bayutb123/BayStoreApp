package com.bayutb.baystoreapp.presentation.screen

sealed class Screen(val route: String) {
    object Home: Screen(HOME)
    object Catalog: Screen(CATALOG)

    companion object {
        private const val HOME = "home"
        private const val CATALOG = "catalog"
        private const val CHECKOUT = "checkout"
    }

}

