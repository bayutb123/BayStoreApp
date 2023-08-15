package com.bayutb.baystoreapp.presentation.screen.payment

import androidx.lifecycle.ViewModel
import com.bayutb.baystoreapp.domain.usecase.OrderUseCase
import com.bayutb.baystoreapp.domain.model.OrderDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val useCase: OrderUseCase
) : ViewModel () {
    fun getOrderData(
        accountId: Int,
        itemId: Int,
        paymentId: Int
    ) : OrderDetail {
        return OrderDetail(
            account = useCase.getAccountById(accountId),
            inGameCurrency = useCase.getItemById(itemId),
            paymentMethod = useCase.getPaymentById(paymentId),
            paymentCode = 94431354685494
        )
    }
}