package com.thomnt.medi365.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.thomnt.medi365.R

class MissionView constructor(
    ctx: Context,
    attrs: AttributeSet?
) : LinearLayout(ctx, attrs) {

    private var llMission: LinearLayout? = null
    private var ivMission: ImageView? = null
    private var tvMission: TextView? = null
    private var messionIcon: Drawable? = null
    private var messionBg: Drawable? = null
    var missionLabel: CharSequence? = null
    var missionColorLabel = 0
    var isShowMissionLabel: Boolean = false

    private var onMissionClick: (() -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.misson_view_layout, this, true)
        initView(attrs)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        llMission = findViewById(R.id.llMission)
        ivMission = findViewById(R.id.ivMission)
        tvMission = findViewById(R.id.tvMission)

        if (missionLabel != null) {
            tvMission?.text = missionLabel
        }

        if(messionIcon !=  null){
            ivMission?.setImageDrawable(messionIcon)
        }

        if(messionBg !=  null){
            llMission?.background = messionBg
        }

        if (missionColorLabel != 0) {
            tvMission?.setTextColor(missionColorLabel)
        }

        llMission?.setOnClickListener {
            onMissionClick?.invoke()
        }

        if(isShowMissionLabel){
            tvMission?.visibility = VISIBLE
        }else{
            tvMission?.visibility = GONE
        }
    }

    fun setOnMissionClickListener(onClick: (() -> Unit)?) {
        this.onMissionClick = onClick
    }

    private fun initView(attrs: AttributeSet?) {
        val ta = context.theme.obtainStyledAttributes(attrs, R.styleable.MissionView, 0, 0)

        if (ta.hasValue(R.styleable.MissionView_mv_icon)) {
            messionIcon = ta.getDrawable(R.styleable.MissionView_mv_icon)
        }

        if (ta.hasValue(R.styleable.MissionView_mv_background)) {
            messionBg = ta.getDrawable(R.styleable.MissionView_mv_background)
        }

        if (ta.hasValue(R.styleable.MissionView_mv_text)) {
            missionLabel = ta.getString(R.styleable.MissionView_mv_text)
        }

        if (ta.hasValue(R.styleable.MissionView_mv_text_color)) {
            missionColorLabel = ta.getColor(R.styleable.MissionView_mv_text_color, 0)
        }

        if (ta.hasValue(R.styleable.MissionView_mv_show_text)) {
            isShowMissionLabel = ta.getBoolean(R.styleable.MissionView_mv_text_color, false)
        }

        ta.recycle()
    }
}
