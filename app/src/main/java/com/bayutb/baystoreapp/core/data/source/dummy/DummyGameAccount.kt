package com.bayutb.baystoreapp.core.data.source.dummy

import com.bayutb.baystoreapp.domain.model.GameAccount
import java.util.concurrent.Flow

object DummyGameAccount {
    private val _gameAccounts = mutableListOf<GameAccount>()
    private val gameAccounts : List<GameAccount> = _gameAccounts

    init {
        _gameAccounts.add(
            GameAccount(
                id = 923123123,
                name = "NORTY",
                server = 2323,
                level = 99
            )
        )
        _gameAccounts.add(
            GameAccount(
                id = 1323123,
                name = "NOUSSS",
                server = 0,
                level = 60
            )
        )
    }

    fun getAllGames() : List<GameAccount> = gameAccounts

    fun getGameAccountById(id: Int) : GameAccount {
        return gameAccounts.first() { it.id == id }
    }
}