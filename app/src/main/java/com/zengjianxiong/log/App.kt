package com.zengjianxiong.log

import android.app.Application
import com.zengjianxiong.corelog.AnalyticsManager
import com.zengjianxiong.dblog.DBLogTree
import com.zengjianxiong.filelog.FileLoggingTree


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AnalyticsManager.getInstance(true, tree = FileLoggingTree(context = this))
    }
}