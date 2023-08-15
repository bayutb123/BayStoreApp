package com.bayutb.baystoreapp.domain.repository

import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import com.bayutb.baystoreapp.domain.model.PaymentMethod

interface OrderRepository {

    fun getAccountData(id: Int) : GameAccount
    fun getItemData(id: Int): InGameCurrency
    fun getPaymentData(id: Int): PaymentMethod

}