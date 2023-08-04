package com.bayutb.baystoreapp.core.data.source.dummy

import com.bayutb.baystoreapp.domain.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

object DummyGame {
    private val games = mutableListOf<Game>()
    fun initAllGames(id: Int) {
        games.add(
            Game(
                id = id,
                name = "Mobile Legends : Bang Bang $id",
                imageUrl = "https://play-lh.googleusercontent.com/UELcKakJhwKhdDJIwpdvd1RjE3ClRXiG0nhChs69fBv-nn5ZkgSp2EkkRTnJYFtYoZyu=s48-rw",
                publisher = "Moontoon",
                popularity = Random.nextInt(1,100)
            )
        )
    }

    fun getAllGames() : Flow<List<Game>> {
        return flow {
            games
        }
    }

    fun getHotGames() : Flow<List<Game>> {
        return flow {
            games.filter { it.popularity > 60 }
        }
    }
}