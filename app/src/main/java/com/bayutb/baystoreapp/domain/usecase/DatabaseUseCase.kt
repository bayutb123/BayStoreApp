package com.bayutb.baystoreapp.domain.usecase

import com.bayutb.baystoreapp.domain.model.Orders
import com.bayutb.baystoreapp.domain.repository.DatabaseRepository
import javax.inject.Inject

class DatabaseUseCase @Inject constructor(
    private val repository: DatabaseRepository
) {
    suspend fun insertOrder(orders: Orders) {
        repository.insertOrder(orders)
    }
}