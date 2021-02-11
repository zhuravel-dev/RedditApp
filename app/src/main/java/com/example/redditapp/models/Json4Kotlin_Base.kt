package com.example.redditapp.models

import com.google.gson.annotations.SerializedName


data class Json4Kotlin_Base (

	@SerializedName("kind") val kind : String,
	@SerializedName("data") val data : Data
)