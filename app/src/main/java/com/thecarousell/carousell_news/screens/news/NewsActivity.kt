package com.thecarousell.carousell_news.screens.news

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.thecarousell.carousell_news.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    private val newsViewModel: NewsViewModel by viewModels()
    private val binding by lazy { ActivityNewsBinding.inflate(layoutInflater) }
    private val newsAdapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerView()

        observeViewModel()
        newsViewModel.getNews()
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@NewsActivity)
            adapter = newsAdapter
        }
    }

    private fun observeViewModel() {
        newsViewModel.newsItems.observe(this, newsAdapter::setItems)
    }
}