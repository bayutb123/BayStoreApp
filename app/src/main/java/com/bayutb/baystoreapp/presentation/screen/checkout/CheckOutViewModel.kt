package com.bayutb.baystoreapp.presentation.screen.checkout

import androidx.lifecycle.ViewModel
import com.bayutb.baystoreapp.domain.model.PaymentMethod
import com.bayutb.baystoreapp.domain.usecase.PaymentMethodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckOutViewModel @Inject constructor(
    private val useCase: PaymentMethodUseCase
) : ViewModel() {
    private val _paymentMethods = mutableListOf<PaymentMethod>()
    val paymentMethods : List<PaymentMethod> = _paymentMethods

    init {
        useCase.invoke().forEach {
            _paymentMethods.add(it)
        }
    }
}