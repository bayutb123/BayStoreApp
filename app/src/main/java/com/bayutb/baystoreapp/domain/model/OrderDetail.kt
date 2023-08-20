package com.bayutb.baystoreapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bayutb.baystoreapp.domain.model.GameAccount
import com.bayutb.baystoreapp.domain.model.InGameCurrency
import com.bayutb.baystoreapp.domain.model.PaymentMethod

data class OrderDetail(
    val account: UserIGN,
    val inGameCurrency: InGameCurrency,
    val paymentMethod: PaymentMethod,
    val paymentCode: Long?
)
