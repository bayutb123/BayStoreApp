package com.bayutb.baystoreapp.core.di

import com.bayutb.baystoreapp.core.data.repository.ItemRepositoryImpl
import com.bayutb.baystoreapp.core.data.source.dummy.DummyItem
import com.bayutb.baystoreapp.domain.repository.ItemRepository
import com.bayutb.baystoreapp.domain.usecase.ItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ItemModule {

    @Provides
    @Singleton
    fun provideDummyItem() : DummyItem = DummyItem

    @Provides
    @Singleton
    fun provideItemRepository(dummyItem: DummyItem): ItemRepository = ItemRepositoryImpl(dummyItem)

    @Provides
    @Singleton
    fun provideItemUseCase(itemRepository: ItemRepository): ItemUseCase = ItemUseCase(itemRepository)

}