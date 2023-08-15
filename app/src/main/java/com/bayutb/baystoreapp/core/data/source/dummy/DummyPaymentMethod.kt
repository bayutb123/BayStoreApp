package com.bayutb.baystoreapp.core.data.source.dummy

import com.bayutb.baystoreapp.domain.model.PaymentMethod

object DummyPaymentMethod {
    private val _paymentMethods = mutableListOf<PaymentMethod>()
    private val paymentMethods: List<PaymentMethod> = _paymentMethods

    init {
        _paymentMethods.add(
            PaymentMethod(
                id = 1,
                name = "Bay-Wallet",
                logo = "https://www.clipartmax.com/png/small/259-2596826_wallet-icon-wallet-logo-transparent.png"
            )
        )
        _paymentMethods.add(
            PaymentMethod(
                id = 2,
                name = "Go-Pay",
                logo = "https://gopay.co.id/icon.png"
            )
        )
        _paymentMethods.add(
            PaymentMethod(
                id = 3,
                name = "OVO",
                logo = "https://1.bp.blogspot.com/-Iq0Ztu117_8/XzNYaM4ABdI/AAAAAAAAHA0/MabT7B02ErIzty8g26JvnC6cPeBZtATNgCLcBGAsYHQ/s1000/logo-ovo.png"
            )
        )
    }

    fun getAllPaymentMethods(): List<PaymentMethod> {
        return paymentMethods
    }

    fun getPaymentById(id: Int): PaymentMethod {
        return paymentMethods.first() { it.id == id }
    }
}