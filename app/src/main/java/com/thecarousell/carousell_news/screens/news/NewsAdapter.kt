package com.thecarousell.carousell_news.screens.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.compose.AsyncImage
import com.thecarousell.carousell_news.data.model.News
import com.thecarousell.carousell_news.databinding.ItemNewsBinding
import org.intellij.lang.annotations.JdkConstants

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ComposeNewsViewHolder>() {
    private val items = mutableListOf<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComposeNewsViewHolder =
        ComposeNewsViewHolder(ComposeView(parent.context))

    override fun onBindViewHolder(holder: ComposeNewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    // XML Version - Comment out the Compose version above and uncomment this to use XML
    /*
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }
    */

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: List<News>) {
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = items.size
            override fun getNewListSize(): Int = newItems.size
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition].id == newItems[newItemPosition].id

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition] == newItems[newItemPosition]
        })
        items.clear()
        items.addAll(newItems)
        diff.dispatchUpdatesTo(this)
    }

    // XML ViewHolder - Uncomment this and comment out Compose version to use XML
    /*
    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News) {

        }
    }
    */

    inner class ComposeNewsViewHolder(private val composeView: ComposeView) :
        RecyclerView.ViewHolder(composeView) {

        fun bind(news: News) {
            composeView.setContent {
                NewsItemCompose(news)
            }
        }
    }

    @Composable
    private fun NewsItemCompose(news: News) {
      Card(

      ) {

          AsyncImage(model = news.bannerUrl,
              contentDescription = "empty",


              )










      }
        Text(
            news.title
            

        )
    }

}