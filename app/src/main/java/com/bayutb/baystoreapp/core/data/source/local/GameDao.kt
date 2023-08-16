package com.bayutb.baystoreapp.core.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bayutb.baystoreapp.domain.model.Orders
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {


    @Query("SELECT * FROM Orders")
    fun getAllOrders() : Flow<List<Orders>>

    @Insert
    suspend fun insertOrder(orders: Orders)

}