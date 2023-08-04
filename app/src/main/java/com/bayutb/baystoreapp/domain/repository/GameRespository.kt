package com.bayutb.baystoreapp.domain.repository

import com.bayutb.baystoreapp.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRespository {
    fun getHotGames() : Flow<List<Game>>
    fun getAllGames() : Flow<List<Game>>
}