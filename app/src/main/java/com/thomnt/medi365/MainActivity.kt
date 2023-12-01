package com.thomnt.medi365

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.thomnt.medi365.databinding.MainActivityBinding
import com.thomnt.medi365.presentation.calender.CalenderFragment
import com.thomnt.medi365.presentation.home.HomeFragment
import com.thomnt.medi365.presentation.menu.MenuFragment
import com.thomnt.medi365.presentation.news.NewsFragment
import com.thomnt.medi365.presentation.search.SearchFragment
import com.thomnt.medi365.widget.Tab
import com.thomnt.medi365.widget.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private var viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
    private var homeFra = HomeFragment()
    private var calenderFra = CalenderFragment()
    private var newsFra = NewsFragment()
    private var searchFra = SearchFragment()
    private var menuFra = MenuFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomMainView()
        setupViewPager()
    }

    private fun setupBottomMainView() {
        binding.bmvMainBottomBar.setOnTabClick {
            binding.vpMain.currentItem = it
        }
    }

    private fun setupViewPager() {
        viewPagerAdapter.addTab(Tab().apply {
            fragment = homeFra
        })
        viewPagerAdapter.addTab(Tab().apply {
            fragment = calenderFra
        })
        viewPagerAdapter.addTab(Tab().apply {
            fragment = newsFra
        })
        viewPagerAdapter.addTab(Tab().apply {
            fragment = searchFra
        })
        viewPagerAdapter.addTab(Tab().apply {
            fragment = menuFra
        })

        binding.vpMain.apply {
            adapter = viewPagerAdapter
//            offscreenPageLimit = viewPagerAdapter.count // giữ trạng thái của tất cả các màn
//            currentItem = 0
            addOnPageSelected {
//                currentTab = it
//                if (currentTab == 3) {
//                    this@MainActivity.supportFragmentManager.popBackStack()
//                }
//                binding.bmvMainBottomBar.setTabSelected(currentTab)
                binding.bmvMainBottomBar.setTabSelected(it)
            }
        }
    }

    private fun showBottomMainView(isShow: Boolean) {
        if (binding.bmvMainBottomBar.isVisible == isShow) return

        Handler(Looper.getMainLooper()).postDelayed({
            binding.bmvMainBottomBar.isVisible = isShow
        }, 100L)
    }


}
