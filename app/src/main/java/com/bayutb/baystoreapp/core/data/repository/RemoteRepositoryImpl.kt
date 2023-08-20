package com.bayutb.baystoreapp.core.data.repository

import com.bayutb.baystoreapp.core.data.source.remote.ApiService
import com.bayutb.baystoreapp.domain.model.GetUserIgnRequest
import com.bayutb.baystoreapp.domain.model.UserIGN
import com.bayutb.baystoreapp.domain.repository.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteRepository {
    override suspend fun getUserIgn(id: String, server: String?, gameCode: String): UserIGN {
        val requestData = GetUserIgnRequest(
            key = "ztMdvhv6OB5uTDezT6fYXlPAsTtsWrJkz98fp0qTOSyAMesaPPyYdHPwp79dhUAz",
            sign = "a87491b2d239c65b221d5ce1a38906fb",
            type = "get-nickname",
            code = gameCode,
            target = id,
            additionalTarget = server
        )
        val response = apiService.getUserIgn(
            key = requestData.key,
            sign = requestData.sign,
            type = requestData.type,
            code = requestData.code,
            target = requestData.target,
            additionalTarget = requestData.additionalTarget
        )
        return UserIGN(inGameNickName = response.data)
    }

}