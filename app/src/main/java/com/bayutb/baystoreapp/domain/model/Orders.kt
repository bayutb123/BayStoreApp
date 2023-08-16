package com.bayutb.baystoreapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Orders")
data class Orders(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val clientId: Int?,
    val itemId: Int,
    val paymentId: Int,
    val date: String
)
