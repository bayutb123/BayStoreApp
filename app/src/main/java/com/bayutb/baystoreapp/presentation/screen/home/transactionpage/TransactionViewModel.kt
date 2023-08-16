package com.bayutb.baystoreapp.presentation.screen.home.transactionpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayutb.baystoreapp.domain.model.Orders
import com.bayutb.baystoreapp.domain.usecase.DatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val databaseUseCase: DatabaseUseCase
) : ViewModel(){
    private val _transactions = mutableListOf<Orders>()
    var transactions: List<Orders> = _transactions

    init {
        viewModelScope.launch {
            databaseUseCase.getAllOrders().collect {
                _transactions.clear()
                _transactions.addAll(it)
            }
        }
    }

}