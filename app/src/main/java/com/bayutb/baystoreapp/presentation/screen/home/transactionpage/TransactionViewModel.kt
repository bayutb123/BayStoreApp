package com.bayutb.baystoreapp.presentation.screen.home.transactionpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayutb.baystoreapp.domain.model.Orders
import com.bayutb.baystoreapp.domain.usecase.DatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val databaseUseCase: DatabaseUseCase
) : ViewModel(){
    var transactions = databaseUseCase.getAllOrders()
}