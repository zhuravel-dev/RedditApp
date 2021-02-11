package com.example.redditapp.models.child

import com.google.gson.annotations.SerializedName

data class ChildDetails(
    @SerializedName("kind") val kind : String,
    @SerializedName("data") val data : ChildData
)
