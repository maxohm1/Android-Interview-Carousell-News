package com.thecarousell.carousell_news.data.repository

import com.thecarousell.carousell_news.data.api.NewsApi
import com.thecarousell.carousell_news.data.model.News
import com.thecarousell.carousell_news.utils.TimeUtil
import javax.inject.Inject

interface NewsRepository {
    suspend fun getNews(): List<News>
}

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val timeUtil: TimeUtil
) : NewsRepository {
    override suspend fun getNews(): List<News> =
        newsApi.getNews()
            .map {
                it.copy(timeAgoString = timeUtil.getTimeAgoString(it.timeCreatedMs))
            }
}