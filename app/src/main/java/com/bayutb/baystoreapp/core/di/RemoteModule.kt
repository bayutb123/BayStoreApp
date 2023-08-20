package com.bayutb.baystoreapp.core.di

import com.bayutb.baystoreapp.core.data.repository.RemoteRepositoryImpl
import com.bayutb.baystoreapp.core.data.source.remote.ApiService
import com.bayutb.baystoreapp.domain.repository.RemoteRepository
import com.bayutb.baystoreapp.domain.usecase.RemoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): ApiService {
        val client = OkHttpClient.Builder()
            .build()

        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://vip-reseller.co.id/api/game-feature/")
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteRepository(apiService: ApiService) : RemoteRepository {
        return RemoteRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideRemoteUseCase(repository: RemoteRepository) : RemoteUseCase {
        return RemoteUseCase(repository)
    }

}