package com.bayutb.baystoreapp.core.data.repository

import com.bayutb.baystoreapp.core.data.source.dummy.DummyGameAccount
import com.bayutb.baystoreapp.core.data.source.dummy.DummyItem
import com.bayutb.baystoreapp.core.data.source.dummy.DummyPaymentMethod
import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import com.bayutb.baystoreapp.domain.model.PaymentMethod
import com.bayutb.baystoreapp.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val dummyItem: DummyItem,
    private val dummyAccount: DummyGameAccount,
    private val dummyPayment: DummyPaymentMethod,
) : OrderRepository {
    override fun getAccountData(id: Int): GameAccount {
        return dummyAccount.getGameAccountById(id)
    }

    override fun getItemData(id: Int): InGameCurrency {
        return dummyItem.getItemById(id)
    }

    override fun getPaymentData(id: Int): PaymentMethod {
        return dummyPayment.getPaymentById(id)
    }

}