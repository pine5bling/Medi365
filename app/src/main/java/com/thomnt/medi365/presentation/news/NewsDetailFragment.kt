package com.thomnt.medi365.presentation.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import com.thomnt.medi365.common.getAppDrawable
import com.thomnt.medi365.common.loadImage
import com.thomnt.medi365.databinding.NewsDetailFragmentBinding
import com.thomnt.medi365.model.News

class NewsDetailFragment : Fragment() {

    companion object {
        const val NEWS_KEY = "NEWS_KEY"
    }

    private lateinit var binding: NewsDetailFragmentBinding
    val bundle: Bundle? = null
    val news: News? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = NewsDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.hvNewsDetail.setOnLeftIconClickListener {
//            OnBackPressedDispatcher()
            requireActivity().onBackPressed()
        }

        val news = arguments?.getParcelable(NEWS_KEY) as? News

        binding.tvNewsDetailName.text = news?.name
        binding.tvNewsDetailTime.text = news?.time
        binding.tvNewsNumberWatch.text = news?.watch.toString()
        if(news?.image!= null){
            binding.ivNewsDetail.loadImage(getAppDrawable(news.image!!))
        }
        binding.tvNewsDetailContent.text = news?.content

    }
}
