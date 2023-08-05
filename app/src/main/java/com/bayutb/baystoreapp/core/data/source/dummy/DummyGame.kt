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
                    name = "Genshin Impact ${it+1}",
                    imageUrl = "https://static.wikia.nocookie.net/gensin-impact/images/8/80/Genshin_Impact.png/revision/latest/scale-to-width-down/350?cb=20230121174225",
                    publisher = "Mihoyo",
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
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuype5ack52BPYLoLjNDn4PHUzsYYzX6jXJrLPLfc&s",
                    publisher = "Moontoon",
                    popularity = Random.nextInt(1,100)
                )
            )
        }
        repeat(3) {
            _games.add(
                Game(
                    id = it+10,
                    name = "Dragon Nest 2 : Evolution ${it+1}",
                    imageUrl = "https://play-lh.googleusercontent.com/FNIpVyI4O1yTj9d7PtImDmXzJDXGnNB9U45s4VrKyb-vhpmxAovq-NnXo9sHDyiTsVI",
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