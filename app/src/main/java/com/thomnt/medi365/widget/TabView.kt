package com.thomnt.medi365.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.thomnt.medi365.R

@SuppressLint("ResourceAsColor")
class TabView constructor(
    val ctx: Context,
    attrs: AttributeSet?
) : LinearLayout(ctx, attrs) {

    private var tvLeft: TextView? = null
    private var onLeftClick: ((TAB) -> Unit)? = null
    private var leftLabel: CharSequence? = null

    private var tvCenter: TextView? = null
    private var onCenterClick: ((TAB) -> Unit)? = null
    private var centerLabel: CharSequence? = null

    private var tvCenterSecond: TextView? = null
    private var onCenterSecondClick: ((TAB) -> Unit)? = null
    private var isShowCenterSecondText = false
    private var centerSecondLabel: CharSequence? = null

    private var tvRight: TextView? = null
    private var onRightClick: ((TAB) -> Unit)? = null
    private var rightLabel: CharSequence? = null

    private var currentTab: TAB? = null
    private var onTabChangeClick: ((TAB) -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.tab_view_layout, this, true)
        initView(attrs)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        tvLeft = findViewById(R.id.tvTabLeft)
        tvCenter = findViewById(R.id.tvTabCenter)
        tvCenterSecond = findViewById(R.id.tvTabSecondCenter)
        tvRight = findViewById(R.id.tvTabRight)

        if (leftLabel != null) {
            tvLeft?.text = leftLabel
        }

        if (centerLabel != null) {
            tvCenter?.text = centerLabel
        }

        if (centerSecondLabel != null) {
            tvCenterSecond?.text = centerSecondLabel
        }

        if (rightLabel != null) {
            tvRight?.text = rightLabel
        }

        if (isShowCenterSecondText) {
            tvCenterSecond?.visibility = VISIBLE
        } else {
            tvCenterSecond?.visibility = GONE
        }

        setOnClickListener()
    }

    fun setOnTabClick(onClick: ((TAB) -> Unit)?) {
        onTabChangeClick = onClick
    }

    private fun selectTab(tab: TAB) {
        if (currentTab != tab) {
            setTabSelected(tab)
            onTabChangeClick?.invoke(tab)
        }
    }

    private fun setOnClickListener() {
        tvLeft?.setOnClickListener {
            selectTab(TAB.LEFT)
        }

        tvCenter?.setOnClickListener {
            selectTab(TAB.CENTER)
        }

        tvCenterSecond?.setOnClickListener {
            selectTab(TAB.CENTER_2)
        }

        tvRight?.setOnClickListener {
            selectTab(TAB.RIGHT)
        }
    }


//    fun setOnLeftClick(onClick: ((TAB) -> Unit)?) {
//        onLeftClick = onClick
//    }
//
//    fun setOnCenterClick(onClick: ((TAB) -> Unit)?) {
//        onCenterClick = onClick
//    }
//
//    fun setOnCenterSecondClick(onClick: ((TAB) -> Unit)?) {
//        onCenterSecondClick = onClick
//    }
//
//    fun setOnRightClick(onClick: ((TAB) -> Unit)?) {
//        onRightClick = onClick
//    }

//    private fun setOnClickListener() {
//        tvLeft?.setOnClickListener {
//            setTabSelected(TAB.LEFT)
//            onLeftClick?.invoke(TAB.LEFT)
//        }
//
//        tvCenter?.setOnClickListener {
//            setTabSelected(TAB.CENTER)
//            onCenterClick?.invoke(TAB.CENTER)
//        }
//
//        tvCenterSecond?.setOnClickListener {
//            setTabSelected(TAB.CENTER_2)
//            onCenterClick?.invoke(TAB.CENTER_2)
//        }
//
//        tvRight?.setOnClickListener {
//            setTabSelected(TAB.RIGHT)
//            onRightClick?.invoke(TAB.RIGHT)
//        }
//    }

    private fun setDefaultBg() {
        tvLeft?.setTextColor(getAppColor(R.color.blue))
        tvLeft?.setBackgroundResource(R.drawable.shape_white_bg_blue_stroke_corner_left_16)

        tvCenter?.setTextColor(getAppColor(R.color.blue))
        tvCenter?.setBackgroundResource(R.drawable.shape_white_bg_blue_stroke)

        tvCenterSecond?.setTextColor(getAppColor(R.color.blue))
        tvCenterSecond?.setBackgroundResource(R.drawable.shape_white_bg_blue_stroke)

        tvRight?.setTextColor(getAppColor(R.color.blue))
        tvRight?.setBackgroundResource(R.drawable.shape_white_bg_blue_stroke_corner_right_16)
    }

    fun setTabSelected(tab: TAB) {
        setDefaultBg()
        currentTab = tab
        when (tab) {
            TAB.LEFT -> {
                tvLeft?.setTextColor(getAppColor(R.color.white))
                tvLeft?.setBackgroundResource(R.drawable.shape_blue_bg_corner_left_16)
            }
            TAB.CENTER -> {
                tvCenter?.setTextColor(getAppColor(R.color.white))
                tvCenter?.setBackgroundResource(R.color.blue)
            }
            TAB.CENTER_2 -> {
                tvCenterSecond?.setTextColor(getAppColor(R.color.white))
                tvCenterSecond?.setBackgroundResource(R.color.blue)
            }
            TAB.RIGHT -> {
                tvRight?.setTextColor(getAppColor(R.color.white))
                tvRight?.setBackgroundResource(R.drawable.shape_blue_bg_corner_right_16)
            }
        }
    }

    private fun initView(attrs: AttributeSet?) {
        val ta = context.theme.obtainStyledAttributes(attrs, R.styleable.TabView, 0, 0)

        if (ta.hasValue(R.styleable.TabView_tv_text_first)) {
            leftLabel = ta.getString(R.styleable.TabView_tv_text_first)
        }

        if (ta.hasValue(R.styleable.TabView_tv_text_second)) {
            centerLabel = ta.getString(R.styleable.TabView_tv_text_second)
        }

        if (ta.hasValue(R.styleable.TabView_tv_text_third)) {
            centerSecondLabel = ta.getString(R.styleable.TabView_tv_text_third)
        }

        if (ta.hasValue(R.styleable.TabView_tv_text_fourth)) {
            rightLabel = ta.getString(R.styleable.TabView_tv_text_fourth)
        }

        if (ta.hasValue(R.styleable.TabView_tv_show_center_second)) {
            isShowCenterSecondText = ta.getBoolean(R.styleable.TabView_tv_show_center_second, true)
        }

        ta.recycle()
    }

    enum class TAB {
        LEFT,
        CENTER,
        CENTER_2,
        RIGHT
    }

    private fun getAppColor(@ColorRes colorRes: Int, context: Context? = ctx) =
        context?.let { ContextCompat.getColor(it, colorRes) } ?: Color.TRANSPARENT
}
