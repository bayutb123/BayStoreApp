package com.bayutb.baystoreapp.domain.model

data class Game(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val publisher: String,
    val popularity: Int
)
