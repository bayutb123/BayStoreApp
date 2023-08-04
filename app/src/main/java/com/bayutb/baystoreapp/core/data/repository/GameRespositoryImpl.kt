package com.bayutb.baystoreapp.core.data.repository

import com.bayutb.baystoreapp.core.data.source.dummy.DummyGame
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.repository.GameRespository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameRespositoryImpl @Inject constructor(
    private val dummyGame: DummyGame
) : GameRespository {

    init {
        repeat(20) {
            dummyGame.initAllGames(it)
        }
    }

    override fun getHotGames(): Flow<List<Game>> {
        return dummyGame.getHotGames()
    }

    override fun getAllGames(): Flow<List<Game>> {
        return dummyGame.getAllGames()
    }

}