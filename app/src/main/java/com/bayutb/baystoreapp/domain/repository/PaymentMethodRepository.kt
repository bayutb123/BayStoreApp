package com.bayutb.baystoreapp.domain.repository

import com.bayutb.baystoreapp.domain.model.PaymentMethod

interface PaymentMethodRepository {

    fun getAllPaymentMethods() : List<PaymentMethod>

}