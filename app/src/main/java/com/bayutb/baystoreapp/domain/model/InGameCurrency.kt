package com.bayutb.baystoreapp.domain.model

data class InGameCurrency(
    val id: Int,
    val name: String,
    val baseCount: Int,
    val bonusItem: Int?,
    val price: Int
)
