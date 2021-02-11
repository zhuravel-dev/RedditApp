package com.example.redditapp.models

import com.google.gson.annotations.SerializedName

data class Preview (

	@SerializedName("images") val images : List<Images>,
	@SerializedName("enabled") val enabled : Boolean
)