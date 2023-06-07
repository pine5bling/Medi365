package com.thomnt.medi365.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.thomnt.medi365.R

class OptionView constructor(
    ctx: Context,
    attrs: AttributeSet?
) : LinearLayout(ctx, attrs) {

    private var tvLabel: TextView? = null
    private var label: CharSequence? = null

    private var tvOption: TextView? = null

    private var ivOption: ImageView? = null

    private var rlOption: RelativeLayout? = null
    private var onOptionClick: (() -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.option_view_layout, this, true)
        initView(attrs)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        tvLabel = findViewById(R.id.tvOptionLabel)
        rlOption = findViewById(R.id.rlOption)
        tvOption = findViewById(R.id.tvOptionContent)
        ivOption = findViewById(R.id.ivOptionDown)

        if (label != null) {
            tvLabel?.text = label
        }

        rlOption?.setOnClickListener {
            onOptionClick?.invoke()
        }
    }

    private fun initView(attrs: AttributeSet?) {
        val ta = context.theme.obtainStyledAttributes(attrs, R.styleable.OptionView, 0, 0)

        if (ta.hasValue(R.styleable.OptionView_ov_label)) {
            label = ta.getString(R.styleable.OptionView_ov_label)
        }

        ta.recycle()
    }

}
