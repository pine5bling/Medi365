package com.thomnt.medi365.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.thomnt.medi365.R

class HeaderView constructor(
    ctx: Context,
    attrs: AttributeSet?
) : ConstraintLayout(ctx, attrs) {

    private var ivLeft: ImageView? = null
    var leftIcon: Drawable? = null
    private var onLeftClick: (() -> Unit)? = null
    private var isShowLeftIcon: Boolean = false

    private var tvCenter: TextView? = null
    private var centerLabel: CharSequence? = null
    private var onCenterClick: (() -> Unit)? = null

    private var ivRight: ImageView? = null
    var rightIcon: Drawable? = null
    private var onRightClick: (() -> Unit)? = null
    private var isShowRightIcon: Boolean = false
    private lateinit var tvNotificationNumber: TextView
    private lateinit var flNotificationNumber: FrameLayout
    private lateinit var vNotification: View
    private var isShowNotificationNumber: Boolean = false

    private var vDivider: View? = null
    private var isShowDivider: Boolean = false

    init {
        LayoutInflater.from(context).inflate(R.layout.header_view_layout, this, true)
        initView(attrs)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        ivLeft = findViewById(R.id.ivHeaderLeftIcon)
        tvCenter = findViewById(R.id.tvHeaderCenterText)
        ivRight = findViewById(R.id.ivHeaderRightIcon)
        vDivider = findViewById(R.id.vDivider)
        vNotification = findViewById(R.id.vHeaderNotification)
        tvNotificationNumber = findViewById(R.id.tvHeaderNotificationNumber)
        flNotificationNumber = findViewById(R.id.flHeaderNotificationNumber)

        if (leftIcon != null) {
            ivLeft?.setImageDrawable(leftIcon)
            ivLeft?.visibility = VISIBLE
        } else {
            ivLeft?.visibility = GONE
        }

        if (isShowLeftIcon) {
            ivLeft?.visibility = VISIBLE
        } else {
            ivLeft?.visibility = GONE
        }

        if (centerLabel != null) {
            tvCenter?.text = centerLabel
        }

        if (rightIcon != null) {
            ivRight?.setImageDrawable(rightIcon)
            ivRight?.visibility = VISIBLE
        } else {
            ivRight?.visibility = GONE
        }

        if (isShowRightIcon) {
            ivRight?.visibility = VISIBLE
        } else {
            ivRight?.visibility = GONE
        }

        if (isShowDivider) {
            vDivider?.visibility = VISIBLE
        } else {
            vDivider?.visibility = GONE
        }

        if (isShowNotificationNumber) {
            flNotificationNumber.visibility = VISIBLE
        } else {
            flNotificationNumber.visibility = GONE
        }

        setOnClickListener()
    }

    private fun setOnClickListener() {
        ivLeft?.setOnClickListener {
            onLeftClick?.invoke()
        }
        tvCenter?.setOnClickListener {
            onCenterClick?.invoke()
        }
        ivRight?.setOnClickListener {
            onRightClick?.invoke()
        }
    }

    fun setOnLeftIconClickListener(onClick: (() -> Unit)?) {
        this.onLeftClick = onClick
    }

    fun setOnCenterTextClickListener(onClick: (() -> Unit)?) {
        this.onCenterClick = onClick
    }

    fun setOnRightIconClickListener(onClick: (() -> Unit)?) {
        this.onRightClick = onClick
    }

    private fun initView(attrs: AttributeSet?) {

        val ta = context.theme.obtainStyledAttributes(attrs, R.styleable.HeaderView, 0, 0)

        if (ta.hasValue(R.styleable.HeaderView_hv_left_icon)) {
            leftIcon = ta.getDrawable(R.styleable.HeaderView_hv_left_icon)
        }

        if (ta.hasValue(R.styleable.HeaderView_hv_show_left_icon)) {
            isShowLeftIcon = ta.getBoolean(R.styleable.HeaderView_hv_show_left_icon, true)
        }

        if (ta.hasValue(R.styleable.HeaderView_hv_center_text)) {
            centerLabel = ta.getString(R.styleable.HeaderView_hv_center_text)
        }

        if (ta.hasValue(R.styleable.HeaderView_hv_right_icon)) {
            rightIcon = ta.getDrawable(R.styleable.HeaderView_hv_right_icon)
        }

        if (ta.hasValue(R.styleable.HeaderView_hv_show_notification_number)) {
            isShowNotificationNumber = ta.getBoolean(R.styleable.HeaderView_hv_show_notification_number, true)
        }

        if (ta.hasValue(R.styleable.HeaderView_hv_show_right_icon)) {
            isShowRightIcon = ta.getBoolean(R.styleable.HeaderView_hv_show_right_icon, true)
        }

        if (ta.hasValue(R.styleable.HeaderView_hv_show_divider)) {
            isShowDivider = ta.getBoolean(R.styleable.HeaderView_hv_show_divider, true)
        }

    }

}
