package com.bayutb.baystoreapp.presentation.components

import java.text.NumberFormat
import java.util.Currency

fun convertToRupiah(value :Int) : String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.maximumFractionDigits = 0
    numberFormat.currency = Currency.getInstance("IDR")
    return numberFormat.format(value)
}