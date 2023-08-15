package com.bayutb.baystoreapp.presentation.screen.checkout

import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import com.bayutb.baystoreapp.domain.model.PaymentMethod

data class OrderDetail(
    val account: GameAccount,
    val inGameCurrency: InGameCurrency,
    val paymentMethod: PaymentMethod
)
