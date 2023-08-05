package com.bayutb.baystoreapp.presentation.screen.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGame
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gameUseCase: GameUseCase
) : ViewModel() {
    private val _games = mutableStateOf(GameState())
    val games: State<GameState> = _games
    private val _hotGames = mutableStateOf(GameState())
    val hotGames: State<GameState> = _hotGames

    private var getGamesJob: Job? = null

    // TEMPORARY DUMMY
    var allGames = emptyList<Game>()
    var allHotGames = emptyList<Game>()

    init {
        initData()
        allGames = DummyGame.games
        allHotGames = allGames.filter { it.popularity > 70 }
    }

    private fun initData() {
        getGamesJob?.cancel()
        gameUseCase()
            .onEach { gamesList ->
            _games.value = games.value.copy(
                games = gamesList
            )
        }.launchIn(viewModelScope)
        Log.d("HVM", games.value.games.size.toString())
    }
}

