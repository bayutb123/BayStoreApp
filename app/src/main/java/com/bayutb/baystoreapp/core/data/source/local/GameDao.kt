package com.bayutb.baystoreapp.core.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import com.bayutb.baystoreapp.domain.model.Orders

@Dao
interface GameDao {

    @Insert
    suspend fun insertOrder(orders: Orders)

}