package com.zengjianxiong.log

import android.app.Application
import com.zengjianxiong.library.AnalyticsManager

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        AnalyticsManager.getInstance(this)
    }
}