package com.thomnt.medi365.presentation.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomnt.medi365.common.getAppDrawable
import com.thomnt.medi365.common.loadImage
import com.thomnt.medi365.databinding.NewsItemLayoutBinding
import com.thomnt.medi365.model.News

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsVH>() {
    private val newsList = mutableListOf<News>()
    var listener: INewsListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        val binding = NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsVH(binding)
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        holder.bindData(newsList[position])
    }

    fun resetData(newsList: MutableList<News>) {
        this.newsList.clear()
        this.newsList.addAll(newsList)
        notifyDataSetChanged()
    }

    override fun getItemCount() = newsList.size

    inner class NewsVH(private val binding: NewsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        init {

            binding.llNewsContainer.setOnClickListener {
                val item = newsList[absoluteAdapterPosition] as? News
                if (item != null) {
                    listener?.onNewsClick(item)
                }
            }
        }

        fun bindData(news: News) {
            binding.ivNews.loadImage(getAppDrawable(news.image!!))
            binding.tvNewsName.text = news.name
            binding.tvNewsContent.text = news.content
            binding.tvNewsTime.text = news.time
            binding.tvNewsNumberWatch.text = news.watch.toString()
        }
    }

    interface INewsListener {
        fun onNewsClick(news: News)
    }
}
