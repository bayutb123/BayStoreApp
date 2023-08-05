package com.bayutb.baystoreapp.core.di

import com.bayutb.baystoreapp.core.data.repository.GameRespositoryImpl
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGame
import com.bayutb.baystoreapp.domain.repository.GameRespository
import com.bayutb.baystoreapp.domain.usecase.GameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameModule {

    @Provides
    @Singleton
    fun provideDummyGame() : DummyGame {
        return DummyGame
    }

    @Provides
    @Singleton
    fun provideGameRepository(dummyGame : DummyGame) : GameRespository {
        return GameRespositoryImpl(dummyGame)
    }

    @Provides
    @Singleton
    fun provideGameUseCase(gameRepository: GameRespository) : GameUseCase {
        return GameUseCase(gameRepository)
    }

}