package com.bayutb.baystoreapp.core.di

import com.bayutb.baystoreapp.core.data.repository.GameRespositoryImpl
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGame
import com.bayutb.baystoreapp.domain.repository.GameRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGameRepository() : GameRespository {
        return GameRespositoryImpl(DummyGame)
    }

}