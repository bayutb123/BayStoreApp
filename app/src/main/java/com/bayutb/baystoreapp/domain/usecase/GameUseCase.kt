package com.bayutb.baystoreapp.domain.usecase

import android.util.Log
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.repository.GameRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GameUseCase @Inject constructor(
    private val gameRespository: GameRespository
) {
    operator fun invoke(): Flow<List<Game>> {
        return gameRespository.getAllGames().map { data ->
            data.sortedBy { it.name }
        }
    }

}