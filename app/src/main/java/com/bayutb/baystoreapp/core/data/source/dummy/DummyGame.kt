package com.bayutb.baystoreapp.core.data.source.dummy

import android.util.Log
import com.bayutb.baystoreapp.domain.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

object DummyGame {
    private val _games = mutableListOf<Game>()
    val games: List<Game> = _games
    init {
        repeat(3) {
            _games.add(
                Game(
                    id = it+1,
                    name = "Mobile Legends : Bang Bang ${it+1}",
                    imageUrl = "https://i.pinimg.com/originals/8d/9a/fa/8d9afa6ccb58639ffb98130ac0256e04.jpg",
                    publisher = "Moontoon",
                    popularity = Random.nextInt(1,100)
                )
            )
        }
        repeat(3) {
            _games.add(
                Game(
                    id = it+4,
                    name = "PUBG MOBILE ${it+1}",
                    imageUrl = "https://yt3.googleusercontent.com/JnmzP-Ti7W8hygyWSLzJqoLkDLbhuQ2BEGNlq-pMmK8S_CjJhqzDr0D32QSMk-HZriAKh_dlsg=s900-c-k-c0x00ffffff-no-rj",
                    publisher = "Level Infinite",
                    popularity = Random.nextInt(1,100)
                )
            )
        }
        repeat(3) {
            _games.add(
                Game(
                    id = it+7,
                    name = "Mobile Legends : Bang Bang ${it+1}",
                    imageUrl = "https://i.pinimg.com/originals/8d/9a/fa/8d9afa6ccb58639ffb98130ac0256e04.jpg",
                    publisher = "Moontoon",
                    popularity = Random.nextInt(1,100)
                )
            )
        }
        repeat(3) {
            _games.add(
                Game(
                    id = it+10,
                    name = "PUBG MOBILE ${it+1}",
                    imageUrl = "https://yt3.googleusercontent.com/JnmzP-Ti7W8hygyWSLzJqoLkDLbhuQ2BEGNlq-pMmK8S_CjJhqzDr0D32QSMk-HZriAKh_dlsg=s900-c-k-c0x00ffffff-no-rj",
                    publisher = "Level Infinite",
                    popularity = Random.nextInt(1,100)
                )
            )
        }
    }

    fun getAllGames() : Flow<List<Game>> {
        return flow {
            games
        }
    }

}