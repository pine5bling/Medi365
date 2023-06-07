package com.thomnt.medi365.presentation.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.thomnt.medi365.R
import com.thomnt.medi365.databinding.NewsFragmentBinding
import com.thomnt.medi365.model.News
import com.thomnt.medi365.model.mockNewsList
import com.thomnt.medi365.presentation.news.NewsDetailFragment.Companion.NEWS_KEY

class NewsFragment : Fragment() {

    private lateinit var binding: NewsFragmentBinding
    private val newsAdapter = NewsAdapter()
    val newsDetailFragment = NewsDetailFragment()
    val bundle: Bundle? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = NewsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        newsAdapter.resetData(mockNewsList())

        newsAdapter.listener = object : NewsAdapter.INewsListener {
            override fun onNewsClick(news: News) {
                newsDetailFragment.arguments = bundleOf(NEWS_KEY to news)
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.llNewsRoot, newsDetailFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }

}
