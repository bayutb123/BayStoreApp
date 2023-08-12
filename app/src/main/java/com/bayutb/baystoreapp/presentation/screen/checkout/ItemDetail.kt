package com.bayutb.baystoreapp.presentation.screen.checkout

import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.model.InGameCurrency

data class ItemDetail(
    val game: Game,
    val item: InGameCurrency
)
