package com.bayutb.baystoreapp.core.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bayutb.baystoreapp.domain.model.OrderDetail
import com.bayutb.baystoreapp.domain.model.Orders

@Database(
    exportSchema = false,
    entities = [Orders::class],
    version = 2
)
abstract class GameDatabase() : RoomDatabase() {
    abstract fun getDao(): GameDao
}