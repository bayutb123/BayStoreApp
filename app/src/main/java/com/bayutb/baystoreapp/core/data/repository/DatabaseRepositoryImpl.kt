package com.bayutb.baystoreapp.core.data.repository

import com.bayutb.baystoreapp.core.data.source.local.GameDao
import com.bayutb.baystoreapp.domain.model.Orders
import com.bayutb.baystoreapp.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val dao: GameDao
) : DatabaseRepository {
    override fun getAllOrders(): Flow<List<Orders>> {
        return dao.getAllOrders()
    }

    override suspend fun insertOrder(orders: Orders) {
        dao.insertOrder(orders)
    }

}