package com.example.redditapp.models


import com.google.gson.annotations.SerializedName


data class Images (

	@SerializedName("source") val source : Source,
	@SerializedName("resolutions") val resolutions : List<Resolutions>,
	@SerializedName("variants") val variants : Variants,
	@SerializedName("id") val id : String
)