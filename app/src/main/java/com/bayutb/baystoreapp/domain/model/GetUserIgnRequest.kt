package com.bayutb.baystoreapp.domain.model

data class GetUserIgnRequest(
    val key: String,
    val sign: String,
    val type: String,
    val code :String,
    val target: String,
    val additionalTarget: String?
)
