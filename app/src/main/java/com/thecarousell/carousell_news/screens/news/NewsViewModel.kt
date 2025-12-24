package com.thecarousell.carousell_news.screens.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thecarousell.carousell_news.data.model.News
import com.thecarousell.carousell_news.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _newsItems = MutableLiveData<List<News>>()
    val newsItems: LiveData<List<News>>
        get() = _newsItems

    fun getNews() {
        viewModelScope.launch {
            try {
                _newsItems.postValue(newsRepository.getNews())
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}