package com.bayutb.baystoreapp.core.di

import com.bayutb.baystoreapp.core.data.repository.OrderRepositoryImpl
import com.bayutb.baystoreapp.core.data.source.dummy.DummyGameAccount
import com.bayutb.baystoreapp.core.data.source.dummy.DummyItem
import com.bayutb.baystoreapp.core.data.source.dummy.DummyPaymentMethod
import com.bayutb.baystoreapp.domain.repository.OrderRepository
import com.bayutb.baystoreapp.domain.usecase.OrderUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrderModule {

    @Provides
    @Singleton
    fun provideAccountDummyData() : DummyGameAccount = DummyGameAccount

    @Provides
    @Singleton
    fun providePaymentRepository(
        dummyPayment: DummyPaymentMethod,
        dummyItem: DummyItem,
        dummyAccount : DummyGameAccount
    ) : OrderRepository {
        return OrderRepositoryImpl(
            dummyAccount = dummyAccount,
            dummyItem = dummyItem,
            dummyPayment = dummyPayment
        )
    }

    @Provides
    @Singleton
    fun provideOrderUseCase(orderRepository: OrderRepository) : OrderUseCase {
        return OrderUseCase(orderRepository)
    }
}