package com.thomnt.medi365.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager constructor(
    context: Context,
    attrs: AttributeSet?
) : ViewPager(context, attrs) {

    init {
        overScrollMode = OVER_SCROLL_NEVER
    }

    private var isPagingEnabled = true

    private var pageIndex: ((Int) -> Unit)? = null

    init {
        addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                pageIndex?.invoke(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return isPagingEnabled && super.onInterceptTouchEvent(event)
    }

    fun setPagingEnabled(isEnabled: Boolean) {
        isPagingEnabled = isEnabled
    }

    fun addOnPageSelected(pageIndex: (Int) -> Unit) {
        this.pageIndex = pageIndex
    }
}
