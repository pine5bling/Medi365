package com.thomnt.medi365.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import com.thomnt.medi365.R

class SearchView constructor(
    ctx: Context,
    attrs: AttributeSet?
) : LinearLayout(ctx, attrs) {

    private var edtSearch: EditText? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.search_view_layout, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        edtSearch = findViewById(R.id.edtSearch)
    }

}
