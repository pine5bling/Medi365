package com.thomnt.medi365.common

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import com.thomnt.medi365.R

private var application: Application? = null

const val LAYOUT_INVALID = -1

fun setApplication(app: Application) {
    application = app
}

fun getApplication() = application ?: throw RuntimeException("Application context mustn't null")

fun getAppDrawable(@DrawableRes drawableId: Int, context: Context? = getApplication()): Drawable? {
    if (context == null) {
        return null
    }
    return ContextCompat.getDrawable(context, drawableId)
}

fun ImageView.loadImage(drawable: Drawable?) {
    setImageDrawable(drawable)
}
