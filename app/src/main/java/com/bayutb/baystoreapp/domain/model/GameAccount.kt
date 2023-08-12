package com.bayutb.baystoreapp.domain.model

data class GameAccount(
    var id: Int,
    val name: String,
    val server: Int,
    val level: Int,
)