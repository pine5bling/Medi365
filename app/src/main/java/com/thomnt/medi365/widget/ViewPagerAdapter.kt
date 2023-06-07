package com.thomnt.medi365.widget

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private var listTab: MutableList<Tab> = mutableListOf()

    override fun getCount(): Int {
        return listTab.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        val tab = listTab[position]
        return tab.string
    }

    override fun getItem(position: Int): Fragment {
        val tab = listTab[position]
        return tab.fragment!!
    }

    fun addTab(tab: Tab) {
        listTab.add(tab)
    }
}

class Tab{
    var fragment : Fragment? = null
    var string : String = ""
}
