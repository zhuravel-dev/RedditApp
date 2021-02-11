package com.example.redditapp.models

import com.google.gson.annotations.SerializedName


data class Author_flair_richtext (

	@SerializedName("e") val e : String,
	@SerializedName("t") val t : String
)