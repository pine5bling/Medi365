package com.thomnt.medi365.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.thomnt.medi365.R

class BottomMainView constructor(
    val ctx: Context,
    attrs: AttributeSet?
) : LinearLayout(ctx, attrs) {

    private lateinit var llHome: LinearLayout
    private lateinit var ivHome: ImageView
    private lateinit var tvHome: TextView

    private lateinit var llCalender: LinearLayout
    private lateinit var ivCalender: ImageView
    private lateinit var tvCalender: TextView

    private lateinit var llNews: LinearLayout
    private lateinit var ivNews: ImageView
    private lateinit var tvNews: TextView

    private lateinit var llSearch: LinearLayout
    private lateinit var ivSearch: ImageView
    private lateinit var tvSearch: TextView

    private lateinit var llMenu: LinearLayout
    private lateinit var ivMenu: ImageView
    private lateinit var tvMenu: TextView

    private var currentPosition: Int = 0
    private var onTabChangeClick: ((position: Int) -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.bottom_main_layout, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        llHome = findViewById(R.id.llBottomMainHome)
        llCalender = findViewById(R.id.llBottomMainCalender)
        llNews = findViewById(R.id.llBottomMainNews)
        llSearch = findViewById(R.id.llBottomMainSearch)
        llMenu = findViewById(R.id.llBottomMainMenu)

        ivHome = findViewById(R.id.ivBottomMainHome)
        ivCalender = findViewById(R.id.ivBottomMainCalender)
        ivNews = findViewById(R.id.ivBottomMainNews)
        ivSearch = findViewById(R.id.ivBottomMainSearch)
        ivMenu = findViewById(R.id.ivBottomMainMenu)

        tvHome = findViewById(R.id.tvBottomMainHome)
        tvCalender = findViewById(R.id.tvBottomMainCalender)
        tvNews = findViewById(R.id.tvBottomMainNews)
        tvSearch = findViewById(R.id.tvBottomMainSearch)
        tvMenu = findViewById(R.id.tvBottomMainMenu)

        setOnClickListener()
    }

    fun setOnTabClick(onClick: ((Int) -> Unit)?) {
        onTabChangeClick = onClick
    }

    private fun selectTab(position: Int) {
        if (currentPosition != position) {
            setTabSelected(position)
            onTabChangeClick?.invoke(position)
        }
    }

    private fun setOnClickListener() {
        llHome.setOnClickListener {
            selectTab(0)
        }

        llCalender.setOnClickListener {
            selectTab(1)
        }

        llNews.setOnClickListener {
            selectTab(2)
        }

        llSearch.setOnClickListener {
            selectTab(3)
        }

        llMenu.setOnClickListener {
            selectTab(4)
        }
    }

    private fun setDefaultColor() {
        ivHome.setBackgroundResource(R.drawable.ic_home)
        ivCalender.setBackgroundResource(R.drawable.ic_calendar)
        ivNews.setBackgroundResource(R.drawable.ic_news)
        ivSearch.setBackgroundResource(R.drawable.ic_search)
        ivMenu.setBackgroundResource(R.drawable.ic_menu)

        tvHome.setTextColorByNeutral7()
        tvCalender.setTextColorByNeutral7()
        tvNews.setTextColorByNeutral7()
        tvSearch.setTextColorByNeutral7()
        tvMenu.setTextColorByNeutral7()
    }

    private fun getTab(position: Int): TAB {
        return when(position) {
            1 -> TAB.CALENDER
            2 -> TAB.NEWS
            3 -> TAB.SEARCH
            4 -> TAB.MENU
            else -> TAB.HOME
        }
    }

    fun setTabSelected(position: Int) {
        setDefaultColor()
        currentPosition = position
        when (getTab(position)) {
            TAB.HOME -> {
                ivHome.setBackgroundResource(R.drawable.ic_home_active)
                tvHome.setTextColorByMediMain()
            }
            TAB.CALENDER -> {
                ivCalender.setBackgroundResource(R.drawable.ic_calender_active)
                tvCalender.setTextColorByMediMain()
            }
            TAB.NEWS -> {
                ivNews.setBackgroundResource(R.drawable.ic_news_active)
                tvNews.setTextColorByMediMain()
            }
            TAB.SEARCH -> {
                ivSearch.setBackgroundResource(R.drawable.ic_search_active)
                tvSearch.setTextColorByMediMain()
            }
            TAB.MENU -> {
                ivMenu.setBackgroundResource(R.drawable.ic_menu_active)
                tvMenu.setTextColorByMediMain()
            }
        }
    }

    enum class TAB {
        HOME,
        CALENDER,
        NEWS,
        SEARCH,
        MENU
    }

    private fun getAppColor(@ColorRes colorRes: Int, context: Context? = ctx) =
        context?.let { ContextCompat.getColor(it, colorRes) } ?: Color.TRANSPARENT

    @SuppressLint("ResourceAsColor")
    fun TextView.setTextColorByNeutral7() {
        setTextColor(getAppColor(R.color.neutral_7))
    }

    @SuppressLint("ResourceAsColor")
    fun TextView.setTextColorByMediMain() {
        setTextColor(getAppColor(R.color.medi_main))
    }
}
