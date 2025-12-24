package com.thecarousell.carousell_news.data.api

import com.thecarousell.carousell_news.data.model.News
import retrofit2.http.GET

interface NewsApi {
    @GET("/carousell-interview-assets/android/carousell_news.json")
    suspend fun getNews(): List<News>
}