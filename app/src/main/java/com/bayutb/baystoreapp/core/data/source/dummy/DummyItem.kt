package com.bayutb.baystoreapp.core.data.source.dummy

import android.util.Log
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object DummyItem {
    private val _items = mutableListOf<InGameCurrency>()
    val items: List<InGameCurrency> = _items
    private const val currentItemId = 0
    init {
        repeat(15) {// TOTAL GAME ITEMS
            repeat(12) { gameId -> // TOTAL CURRENT GAMES
                val id = it.inc()
                Log.d("DummyItem", "Generate itemId $id")
                _items.add(
                    InGameCurrency(
                        id = id,
                        gameId = gameId + 1,
                        name = "Diamonds",
                        iconUrl = "https://static.wikia.nocookie.net/mobile-legends/images/e/ea/Diamond.png/revision/latest?cb=20211127070228",
                        baseCount = (id + 1) * 10,
                        bonusItem = (id + 1) * 2,
                        price = (id + 1) * 10 * 300 * 111 / 100
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

    fun getItemById(id: Int) : InGameCurrency {
        return items.first() {it.id == id}
    }
}