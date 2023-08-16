package com.bayutb.baystoreapp.core.data.repository

import com.bayutb.baystoreapp.core.data.source.local.GameDao
import com.bayutb.baystoreapp.domain.model.Orders
import com.bayutb.baystoreapp.domain.repository.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val dao: GameDao
) : DatabaseRepository {
    override suspend fun insertOrder(orders: Orders) {
        dao.insertOrder(orders)
    }

}