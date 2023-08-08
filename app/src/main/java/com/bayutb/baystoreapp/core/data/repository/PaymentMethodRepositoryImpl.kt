package com.bayutb.baystoreapp.core.data.repository

import com.bayutb.baystoreapp.core.data.source.dummy.DummyPaymentMethod
import com.bayutb.baystoreapp.domain.model.PaymentMethod
import com.bayutb.baystoreapp.domain.repository.PaymentMethodRepository
import javax.inject.Inject

class PaymentMethodRepositoryImpl @Inject constructor(
    private val dummyPaymentMethod: DummyPaymentMethod
) : PaymentMethodRepository {
    override fun getAllPaymentMethods(): List<PaymentMethod> = dummyPaymentMethod.getAllPaymentMethods()

}