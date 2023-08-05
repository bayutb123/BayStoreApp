package com.bayutb.baystoreapp.presentation.screen.catalog

import androidx.lifecycle.ViewModel
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGame
import com.bayutb.baystoreapp.core.data.source.dummy.DummyItem
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import com.bayutb.baystoreapp.domain.usecase.ItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val itemUseCase: ItemUseCase
): ViewModel() {
    private val _items = mutableListOf<InGameCurrency>()
    private val items : List<InGameCurrency> = _items

    // TEMPORARY DUMMY
    var allItems = emptyList<InGameCurrency>()

    private var getItemsJob: Job? = null
    init {
        initiate()
    }

    private fun initiate() {
        getItemsJob?.cancel()
        allItems = DummyItem.items
    }

    fun getItemByGameId(id: Int): List<InGameCurrency> {
        return allItems.filter { it.gameId == id }
    }

    fun getGameDetailById(gameId: Int) : Game {
        return DummyGame.games.first { it.id == gameId }
    }
}