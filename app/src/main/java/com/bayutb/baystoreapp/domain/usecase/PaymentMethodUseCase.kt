package com.bayutb.baystoreapp.domain.usecase

import com.bayutb.baystoreapp.domain.model.PaymentMethod
import com.bayutb.baystoreapp.domain.repository.PaymentMethodRepository
import javax.inject.Inject

class PaymentMethodUseCase @Inject constructor(
    private val repository: PaymentMethodRepository
) {

    operator fun invoke(): List<PaymentMethod> {
        return repository.getAllPaymentMethods()
    }

}