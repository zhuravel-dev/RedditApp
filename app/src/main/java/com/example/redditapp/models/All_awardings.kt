package com.example.redditapp.models


import com.google.gson.annotations.SerializedName


data class All_awardings (

	@SerializedName("giver_coin_reward") val giver_coin_reward : String,
	@SerializedName("subreddit_id") val subreddit_id : String,
	@SerializedName("is_new") val is_new : Boolean,
	@SerializedName("days_of_drip_extension") val days_of_drip_extension : Int,
	@SerializedName("coin_price") val coin_price : Int,
	@SerializedName("id") val id : String,
	@SerializedName("penny_donate") val penny_donate : String,
	@SerializedName("award_sub_type") val award_sub_type : String,
	@SerializedName("coin_reward") val coin_reward : Int,
	@SerializedName("icon_url") val icon_url : String,
	@SerializedName("days_of_premium") val days_of_premium : Int,
	@SerializedName("tiers_by_required_awardings") val tiers_by_required_awardings : String,
	@SerializedName("resized_icons") val resized_icons : List<Resized_icons>,
	@SerializedName("icon_width") val icon_width : Int,
	@SerializedName("static_icon_width") val static_icon_width : Int,
	@SerializedName("start_date") val start_date : String,
	@SerializedName("is_enabled") val is_enabled : Boolean,
	@SerializedName("awardings_required_to_grant_benefits") val awardings_required_to_grant_benefits : String,
	@SerializedName("description") val description : String,
	@SerializedName("end_date") val end_date : String,
	@SerializedName("subreddit_coin_reward") val subreddit_coin_reward : Int,
	@SerializedName("count") val count : Int,
	@SerializedName("static_icon_height") val static_icon_height : Int,
	@SerializedName("name") val name : String,
	@SerializedName("resized_static_icons") val resized_static_icons : List<Resized_static_icons>,
	@SerializedName("icon_format") val icon_format : String,
	@SerializedName("icon_height") val icon_height : Int,
	@SerializedName("penny_price") val penny_price : String,
	@SerializedName("award_type") val award_type : String,
	@SerializedName("static_icon_url") val static_icon_url : String
)