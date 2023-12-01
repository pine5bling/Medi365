package com.thomnt.medi365.widget

import android.widget.LinearLayout

class Test {
    private var llHome: LinearLayout? = null
}

//typealias BOTTOM_MAIN_VIEW_TAB = BottomMainView.TAB

//class BottomMainView constructor(
//    val ctx: Context,
//    attrs: AttributeSet?
//) : LinearLayout(ctx, attrs) {
//
//    private lateinit var llHome: LinearLayout
//    private lateinit var ivHome: ImageView
//    private lateinit var tvHome: TextView
//    private var onHomeClick: ((TAB) -> Unit)? = null
//    private var onTabChangeClick: ((position: Int) -> Unit)? = null
//
//    private lateinit var llCalender: LinearLayout
//    private lateinit var ivCalender: ImageView
//    private lateinit var tvCalender: TextView
//    private var onCalenderClick: ((TAB) -> Unit)? = null
//
//    private lateinit var llNews: LinearLayout
//    private lateinit var ivNews: ImageView
//    private lateinit var tvNews: TextView
//    private var onNewsClick: ((TAB) -> Unit)? = null
//
//    private lateinit var llSearch: LinearLayout
//    private lateinit var ivSearch: ImageView
//    private lateinit var tvSearch: TextView
//    private var onSearchClick: ((TAB) -> Unit)? = null
//
//    private lateinit var llMenu: LinearLayout
//    private lateinit var ivMenu: ImageView
//    private lateinit var tvMenu: TextView
//    private var onMenuClick: ((TAB) -> Unit)? = null
//
//    private var currentTab: TAB? = null
//    private var currentPosition: Int = 0
//
//    init {
//        LayoutInflater.from(context).inflate(R.layout.bottom_main_layout, this, true)
//    }
//
//    override fun onFinishInflate() {
//        super.onFinishInflate()
//
//        llHome = findViewById(R.id.llBottomMainHome)
//        llCalender = findViewById(R.id.llBottomMainCalender)
//        llNews = findViewById(R.id.llBottomMainNews)
//        llSearch = findViewById(R.id.llBottomMainSearch)
//        llMenu = findViewById(R.id.llBottomMainMenu)
//
//        ivHome = findViewById(R.id.ivBottomMainHome)
//        ivCalender = findViewById(R.id.ivBottomMainCalender)
//        ivNews = findViewById(R.id.ivBottomMainNews)
//        ivSearch = findViewById(R.id.ivBottomMainSearch)
//        ivMenu = findViewById(R.id.ivBottomMainMenu)
//
//        tvHome = findViewById(R.id.tvBottomMainHome)
//        tvCalender = findViewById(R.id.tvBottomMainCalender)
//        tvNews = findViewById(R.id.tvBottomMainNews)
//        tvSearch = findViewById(R.id.tvBottomMainSearch)
//        tvMenu = findViewById(R.id.tvBottomMainMenu)
//
//        setOnClickListener()
//    }

//    fun getCurrentTab(): Int {
//        return currentPosition
//    }

//    fun setOnTabClick(onClick: ((Int) -> Unit)?) {
//        onTabChangeClick = onClick
//    }

//    fun setOnHomeClick(onClick: ((TAB) -> Unit)?) {
//        onHomeClick = onClick
//    }
//
//    fun setOnCalenderClick(onClick: ((TAB) -> Unit)?) {
//        onCalenderClick = onClick
//    }
//
//    fun setOnNewsClick(onClick: ((TAB) -> Unit)?) {
//        onNewsClick = onClick
//    }
//
//    fun setOnSearchClick(onClick: ((TAB) -> Unit)?) {
//        onSearchClick = onClick
//    }
//
//    fun setOnMenuClick(onClick: ((TAB) -> Unit)?) {
//        onMenuClick = onClick
//    }
//
//    private fun selectTab(position: Int) {
//        if (currentPosition != position) {
//            setTabSelected(position)
//            onTabChangeClick?.invoke(position)
//        }
//    }
//
//    private fun setOnClickListener() {
//        llHome.setOnClickListener {
//            selectTab(0)
//        }
//
//        llCalender.setOnClickListener {
//            selectTab(1)
//        }
//
//        llNews.setOnClickListener {
//            selectTab(2)
//        }
//
//        llSearch.setOnClickListener {
//            selectTab(3)
//        }
//
//        llMenu.setOnClickListener {
//            selectTab(4)
//        }
//    }
//

//    private fun setOnClickListener() {
//        llHome.setOnClickListener {
//            if (currentTab != TAB.HOME) {
//                setTabSelected(TAB.HOME)
////                onHomeClick?.invoke(TAB.HOME)
//
//            }
//            selectTab(0)
//        }
//
//        llCalender.setOnClickListener {
//            if (currentTab != TAB.CALENDER) {
//                setTabSelected(TAB.CALENDER)
//                onCalenderClick?.invoke(TAB.CALENDER)
//            }
//            selectTab(1)
//        }
//
//        llNews.setOnClickListener {
//            if (currentTab == TAB.NEWS) {
//                setTabSelected(TAB.NEWS)
//                onNewsClick?.invoke(TAB.NEWS)
//            }
//            selectTab(2)
//        }

//        llSearch.setOnClickListener {
//            if (currentTab == TAB.SEARCH) {
//                setTabSelected(TAB.SEARCH)
//                onSearchClick?.invoke(TAB.SEARCH)
//            }
//            selectTab(3)
//        }

//        llMenu.setOnClickListener {
//            if (currentTab == TAB.MENU) {
//                setTabSelected(TAB.MENU)
//                onMenuClick?.invoke(TAB.MENU)
////            }
//            selectTab(4)
//        }
//    }
//
//    private fun getTab(position: Int): TAB {
//        return when(position) {
//            1 -> TAB.CALENDER
//            2 -> TAB.NEWS
//            3 -> TAB.SEARCH
//            4 -> TAB.MENU
//            else -> TAB.HOME
//        }
//    }
//
//    private fun setDefaultColor() {
//        ivHome.setBackgroundResource(R.drawable.ic_home)
//        ivCalender.setBackgroundResource(R.drawable.ic_calendar)
//        ivNews.setBackgroundResource(R.drawable.ic_news)
//        ivSearch.setBackgroundResource(R.drawable.ic_search)
//        ivMenu.setBackgroundResource(R.drawable.ic_menu)
//
//        tvHome.setTextColorByNeutral7()
//        tvCalender.setTextColorByNeutral7()
//        tvNews.setTextColorByNeutral7()
//        tvSearch.setTextColorByNeutral7()
//        tvMenu.setTextColorByNeutral7()
//    }
//
//    fun setTabSelected(position: Int) {
//        setDefaultColor()
//        currentPosition = position
//        when (getTab(position)) {
//            TAB.HOME -> {
//                ivHome.setBackgroundResource(R.drawable.ic_home_active)
//                tvHome.setTextColorByMediMain()
//            }
//            TAB.CALENDER -> {
//                ivCalender.setBackgroundResource(R.drawable.ic_calender_active)
//                tvCalender.setTextColorByMediMain()
//            }
//            TAB.NEWS -> {
//                ivNews.setBackgroundResource(R.drawable.ic_news_active)
//                tvNews.setTextColorByMediMain()
//            }
//            TAB.SEARCH -> {
//                ivSearch.setBackgroundResource(R.drawable.ic_search_active)
//                tvSearch.setTextColorByMediMain()
//            }
//            TAB.MENU -> {
//                ivMenu.setBackgroundResource(R.drawable.ic_menu_active)
//                tvMenu.setTextColorByMediMain()
//            }
//        }
//    }
//
//    enum class TAB {
//        HOME,
//        CALENDER,
//        NEWS,
//        SEARCH,
//        MENU
//    }
//
//    private fun getAppColor(@ColorRes colorRes: Int, context: Context? = ctx) =
//        context?.let { ContextCompat.getColor(it, colorRes) } ?: Color.TRANSPARENT
//
//    @SuppressLint("ResourceAsColor")
//    fun TextView.setTextColorByNeutral7() {
//        setTextColor(getAppColor(R.color.neutral_7))
//    }
//
//    @SuppressLint("ResourceAsColor")
//    fun TextView.setTextColorByMediMain() {
//        setTextColor(getAppColor(R.color.medi_main))
//    }
//}


//package com.thomnt.temptic
//
//import android.os.Bundle
//import android.view.MenuItem
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.viewpager.widget.ViewPager
//import com.google.android.material.navigation.NavigationBarView
//import com.thomnt.temptic.databinding.MainActivityBinding
//import com.thomnt.temptic.presentation.*
//import com.thomnt.temptic.presentation.home.HomeFragment
//import com.thomnt.temptic.widget.BottomMainView
//import com.thomnt.temptic.widget.ViewPagerAdapter
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: MainActivityBinding
//    private var viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
//
//    private var homeFra = HomeFragment()
//    private var storeFra = StoreFragment()
//    private var orderFra = OrderFragment()
//    private var eventFra = EventFragment()
//    private var personalFra = PersonalFragment()
//    //    private var fragmentList = mutableListOf<Fragment>(HomeFragment(), StoreFragment(), OrderFragment(), EventFragment(), PersonalFragment())
//    private var pageIndex: ((Int) -> Unit)? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = MainActivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setupBottomMainView()
//        setupViewPager()
//    }
//
//    fun setupBottomMainView(){
//        binding.bmvBottomBar.setOnItemsClick {
//            binding.vpMain.currentItem = getPosition(it)
//        }
//    }
//
//    fun setupViewPager() {
//        viewPagerAdapter.addTab(fragmentList)
//
//        binding.vpMain.apply {
//            adapter = viewPagerAdapter
//            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onPageSelected(position: Int) {
//                    binding.bmvBottomBar.setItemSelected(getTab(position))
//                }
//
//                override fun onPageScrollStateChanged(state: Int) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//        }
//    }
//
//    private fun getTab(position: Int): BottomMainView.TAB {
//        return when (position) {
//            1 -> BottomMainView.TAB.STORE
//            2 -> BottomMainView.TAB.ORDER
//            3 -> BottomMainView.TAB.EVENT
//            4 -> BottomMainView.TAB.PERSONAL
//            else -> BottomMainView.TAB.HOME
//        }
//    }
//
//    fun getPosition(tab: BottomMainView.TAB): Int {
//        return when (tab) {
//            BottomMainView.TAB.HOME -> 0
//            BottomMainView.TAB.STORE -> 1
//            BottomMainView.TAB.ORDER -> 2
//            BottomMainView.TAB.EVENT -> 3
//            BottomMainView.TAB.PERSONAL -> 4
//        }
//    }
//}
