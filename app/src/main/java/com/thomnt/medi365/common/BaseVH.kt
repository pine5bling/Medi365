package com.thomnt.medi365.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseVH<DATA>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun onBind(data: DATA) {}
}
