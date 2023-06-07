package com.thomnt.medi365.presentation

import android.app.Application
import com.thomnt.medi365.common.setApplication

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        setApplication(this)
    }
}
