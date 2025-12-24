package com.thecarousell.carousell_news.data.model

import com.google.gson.annotations.SerializedName

data class News(
    val id: String,
    val title: String,
    val description: String,
    val bannerUrl: String,
    @SerializedName("time_created")
    private val _timeCreated: Long,
    val rank: Int,
    val timeAgoString: String = ""
) {
    val timeCreatedMs: Long
        get() = _timeCreated * 1000
}
