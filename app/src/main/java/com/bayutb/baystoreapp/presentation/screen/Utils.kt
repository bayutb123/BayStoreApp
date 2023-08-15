package com.bayutb.baystoreapp.presentation.screen

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import androidx.compose.ui.platform.ClipboardManager
import java.text.NumberFormat
import java.util.Currency

fun convertToRupiah(value :Int) : String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.maximumFractionDigits = 0
    numberFormat.currency = Currency.getInstance("IDR")
    return numberFormat.format(value).replace(",", ".").replace("IDR", "Rp ")
}

