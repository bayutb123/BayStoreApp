package com.bayutb.baystoreapp.presentation.screen.checkout

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGame
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGameAccount
import com.bayutb.baystoreapp.core.data.source.dummy.DummyItem
import com.bayutb.baystoreapp.domain.model.Game
import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.PaymentMethod
import com.bayutb.baystoreapp.domain.model.UserIGN
import com.bayutb.baystoreapp.domain.usecase.PaymentMethodUseCase
import com.bayutb.baystoreapp.domain.usecase.RemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckOutViewModel @Inject constructor(
    private val useCase: PaymentMethodUseCase,
    private val remoteUseCase: RemoteUseCase
) : ViewModel() {
    private val _paymentMethods = mutableListOf<PaymentMethod>()
    val paymentMethods: List<PaymentMethod> = _paymentMethods
    private val _userData = MutableStateFlow<UserIGN>(UserIGN(""))
    val userData: StateFlow<UserIGN> = _userData

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

    fun getUserIgn(id: String, server: String?, gameCode: String) {
        viewModelScope.launch {
            _userData.value = remoteUseCase.getUserIgn(id, server, gameCode)
        }
    }


//    fun getAccountById(id: String, server: String): GameAccount? {
//        val idReal = if (id == "") 0 else id.toInt()
//        val serverReal = if (server == "") 0 else server.toInt()
//        return DummyGameAccount.getAllGames()
//            .singleOrNull { it.id == idReal && it.server == serverReal }
//    }

}