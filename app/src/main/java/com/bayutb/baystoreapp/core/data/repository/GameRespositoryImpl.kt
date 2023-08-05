package com.bayutb.baystoreapp.core.data.repository

import android.util.Log
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGame
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.repository.GameRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.count
import javax.inject.Inject

class GameRespositoryImpl @Inject constructor(
    private val dummyGame: DummyGame
) : GameRespository {

    override fun getAllGames(): Flow<List<Game>> {
        return dummyGame.getAllGames()
    }

}