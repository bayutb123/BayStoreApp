package com.bayutb.baystoreapp.domain.repository

import com.bayutb.baystoreapp.domain.model.Orders

interface DatabaseRepository {

    suspend fun insertOrder(orders: Orders)

}