package com.bayutb.baystoreapp.domain.usecase

import com.bayutb.baystoreapp.domain.model.UserIGN
import com.bayutb.baystoreapp.domain.repository.RemoteRepository
import javax.inject.Inject

class RemoteUseCase @Inject constructor(
    private val repository: RemoteRepository
) {
    suspend fun getUserIgn(id: String, server: String?, gameCode: String) : UserIGN {
        return repository.getUserIgn(id, server, gameCode)
    }
}