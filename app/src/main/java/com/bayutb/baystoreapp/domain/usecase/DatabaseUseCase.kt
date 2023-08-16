package com.bayutb.baystoreapp.domain.usecase

import com.bayutb.baystoreapp.domain.model.Orders
import com.bayutb.baystoreapp.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseUseCase @Inject constructor(
    private val repository: DatabaseRepository
) {
    fun getAllOrders(): Flow<List<Orders>> {
        return repository.getAllOrders()
    }
    suspend fun insertOrder(orders: Orders) {
        repository.insertOrder(orders)
    }
}