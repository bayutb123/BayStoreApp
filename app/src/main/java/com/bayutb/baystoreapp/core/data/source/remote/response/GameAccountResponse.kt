package com.bayutb.baystoreapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameAccountResponse(

	@field:SerializedName("result")
	val result: Boolean,

	@field:SerializedName("data")
	val data: String,

	@field:SerializedName("message")
	val message: String
)
