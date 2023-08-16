package com.bayutb.baystoreapp.core.di

import android.content.Context
import androidx.room.Room
import com.bayutb.baystoreapp.core.data.repository.DatabaseRepositoryImpl
import com.bayutb.baystoreapp.core.data.source.local.GameDao
import com.bayutb.baystoreapp.core.data.source.local.GameDatabase
import com.bayutb.baystoreapp.domain.repository.DatabaseRepository
import com.bayutb.baystoreapp.domain.usecase.DatabaseUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            GameDatabase::class.java,
            "game.db"
        ).build()

    @Provides
    @Singleton
    fun provideDao(db: GameDatabase) =
        db.getDao()

    @Provides
    @Singleton
    fun provideDatabaseRepository(dao: GameDao) : DatabaseRepository {
        return DatabaseRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideDatabaseUseCase(repository: DatabaseRepository): DatabaseUseCase {
        return DatabaseUseCase(repository)
    }
}