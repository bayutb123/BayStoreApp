package com.bayutb.baystoreapp.core.data.source.remote

import com.bayutb.baystoreapp.core.data.source.remote.response.GameAccountResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Accept: application/json")
    @POST("game-feature")
    @FormUrlEncoded
    suspend fun getUserIgn(
        @Field("key") key :String,
        @Field("sign") sign: String,
        @Field("type") type: String,
        @Field("code") code: String,
        @Field("target") target: String,
        @Field("additional_target") additionalTarget: String?,
    ) : GameAccountResponse

}