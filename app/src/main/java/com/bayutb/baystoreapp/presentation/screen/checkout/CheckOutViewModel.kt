package com.bayutb.baystoreapp.presentation.screen.checkout

import androidx.lifecycle.ViewModel
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGame
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGameAccount
import com.bayutb.baystoreapp.core.data.source.dummy.DummyItem
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.PaymentMethod
import com.bayutb.baystoreapp.domain.usecase.PaymentMethodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckOutViewModel @Inject constructor(
    private val useCase: PaymentMethodUseCase
) : ViewModel() {
    private val _paymentMethods = mutableListOf<PaymentMethod>()
    val paymentMethods : List<PaymentMethod> = _paymentMethods

    init {
        useCase.invoke().forEach {
            _paymentMethods.add(it)
        }
    }

    fun getItemCurrencyById(id: Int, gameId: Int): ItemDetail {
        return ItemDetail(
            game = DummyGame.games.first() { it.id == gameId },
            item = DummyItem.items.first() { it.id == id }
        )
    }

    fun getGameDetailById(id: Int) : Game {
        return DummyGame.games.first() {
            it.id == id
        }
    }

    fun getAccountById(id: String, server: String): GameAccount? {
        val idReal = if (id == "") 0 else id.toInt()
        val serverReal = if (server == "") 0 else server.toInt()
        return DummyGameAccount.getAllGames()
            .singleOrNull { it.id == idReal && it.server == serverReal }
    }

}