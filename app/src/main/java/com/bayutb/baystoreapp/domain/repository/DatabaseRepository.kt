package com.bayutb.baystoreapp.domain.repository

import com.bayutb.baystoreapp.domain.model.Orders
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    fun getAllOrders(): Flow<List<Orders>>
    suspend fun insertOrder(orders: Orders)

}