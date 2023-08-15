package com.bayutb.baystoreapp.presentation

sealed class Screen(val route: String) {

    object Login: Screen(LOGIN)
    object Home: Screen(HOME)
    object Catalog: Screen(CATALOG)
    object Checkout: Screen(CHECKOUT)
    object Payment: Screen(PAYMENT)

    companion object {
        private const val LOGIN = "login"
        private const val HOME = "home"
        private const val CATALOG = "catalog"
        private const val CHECKOUT = "checkout"
        private const val PAYMENT = "payment"
    }

}

