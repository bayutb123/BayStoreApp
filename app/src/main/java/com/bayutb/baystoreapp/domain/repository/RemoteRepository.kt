package com.bayutb.baystoreapp.domain.repository

import com.bayutb.baystoreapp.domain.model.UserIGN

interface RemoteRepository {

    suspend fun getUserIgn(
        id : String,
        server: String?,
        gameCode: String
    ) : UserIGN

}