package com.bayutb.baystoreapp.presentation.screen.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayutb.baystoreapp.domain.usecase.OrderUseCase
import com.bayutb.baystoreapp.domain.model.OrderDetail
import com.bayutb.baystoreapp.domain.model.Orders
import com.bayutb.baystoreapp.domain.usecase.DatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val useCase: OrderUseCase,
    private val databaseUseCase: DatabaseUseCase
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

    fun insertOrder(orderDetail: OrderDetail) {
        viewModelScope.launch {
            val date = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = date.format(Date())
            databaseUseCase.insertOrder(
                Orders(
                    id = 0,
                    clientId = 1,
                    accountId = orderDetail.account.id,
                    gameId = orderDetail.inGameCurrency.gameId,
                    itemId = orderDetail.inGameCurrency.id,
                    itemName = orderDetail.inGameCurrency.name,
                    itemPrice = orderDetail.inGameCurrency.price,
                    paymentId = orderDetail.paymentMethod.id,
                    date = currentDate
                )
            )
        }
    }
}