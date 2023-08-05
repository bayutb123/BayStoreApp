package com.bayutb.baystoreapp.presentation.screen.home

import com.bayutb.baystoreapp.domain.model.Game

data class GameState(
    val games: List<Game> = emptyList(),
)
