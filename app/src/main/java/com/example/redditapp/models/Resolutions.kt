package com.example.redditapp.models


import com.google.gson.annotations.SerializedName


data class Resolutions (

	@SerializedName("url") val url : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int
)