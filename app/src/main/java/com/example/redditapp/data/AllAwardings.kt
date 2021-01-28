import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class AllAwardings (

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
	@SerializedName("resized_icons") val resized_icons : List<ResizedIcons>,
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
	@SerializedName("resized_static_icons") val resized_static_icons : List<ResizedStaticIcons>,
	@SerializedName("icon_format") val icon_format : String,
	@SerializedName("icon_height") val icon_height : Int,
	@SerializedName("penny_price") val penny_price : String,
	@SerializedName("award_type") val award_type : String,
	@SerializedName("static_icon_url") val static_icon_url : String
)