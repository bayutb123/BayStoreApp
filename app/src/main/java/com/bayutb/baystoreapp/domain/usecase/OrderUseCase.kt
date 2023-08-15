package com.bayutb.baystoreapp.domain.usecase

import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import com.bayutb.baystoreapp.domain.model.PaymentMethod
import com.bayutb.baystoreapp.domain.repository.OrderRepository
import javax.inject.Inject

class OrderUseCase @Inject constructor(
    private val repository: OrderRepository
) {

    fun getItemById(id: Int) : InGameCurrency{
        return repository.getItemData(id)
    }
    fun getAccountById(id: Int) : GameAccount{
        return repository.getAccountData(id)
    }
    fun getPaymentById(id: Int) : PaymentMethod{
        return repository.getPaymentData(id)
    }

}