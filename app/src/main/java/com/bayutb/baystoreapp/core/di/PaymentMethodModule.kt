package com.bayutb.baystoreapp.core.di

import com.bayutb.baystoreapp.core.data.repository.PaymentMethodRepositoryImpl
import com.bayutb.baystoreapp.core.data.source.dummy.DummyPaymentMethod
import com.bayutb.baystoreapp.domain.repository.PaymentMethodRepository
import com.bayutb.baystoreapp.domain.usecase.PaymentMethodUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PaymentMethodModule {

    @Provides
    @Singleton
    fun provideDummyPaymentMethods() : DummyPaymentMethod = DummyPaymentMethod

    @Provides
    @Singleton
    fun providePaymentMethodRepository(dummyPaymentMethod: DummyPaymentMethod) : PaymentMethodRepository {
        return PaymentMethodRepositoryImpl(dummyPaymentMethod)
    }

    @Provides
    @Singleton
    fun providePaymentMethodUseCase(repository: PaymentMethodRepository): PaymentMethodUseCase {
        return PaymentMethodUseCase(repository)
    }

}