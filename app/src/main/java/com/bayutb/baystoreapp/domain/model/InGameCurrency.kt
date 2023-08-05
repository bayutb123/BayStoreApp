package com.bayutb.baystoreapp.domain.model

data class InGameCurrency(
    val id: Int,
    val gameId: Int,
    val name: String,
    val iconUrl: String,
    val baseCount: Int,
    val bonusItem: Int?,
    val price: Int
)
