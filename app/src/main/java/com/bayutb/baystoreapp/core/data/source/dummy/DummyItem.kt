package com.bayutb.baystoreapp.core.data.source.dummy

import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object DummyItem {
    private val _items = mutableListOf<InGameCurrency>()
    val items: List<InGameCurrency> = _items

    init {
        repeat(15) {// TOTAL GAME ITEMS
            repeat(20) { gameId -> // TOTAL CURRENT GAMES
                val id = it + 1
                _items.add(
                    InGameCurrency(
                        id = id,
                        gameId = gameId + 1,
                        name = "diamonds",
                        iconUrl = "https://static.wikia.nocookie.net/mobile-legends/images/e/ea/Diamond.png/revision/latest?cb=20211127070228",
                        baseCount = id * 10,
                        bonusItem = id * 2,
                        price = id * 1500
                    )
                )
            }
        }
    }

    fun getAllItems(): Flow<List<InGameCurrency>> {
        return flow {
            items
        }
    }
}