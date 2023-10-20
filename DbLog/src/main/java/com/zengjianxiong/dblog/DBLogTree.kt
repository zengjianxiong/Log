package com.zengjianxiong.dblog

import android.content.Context
import com.zengjianxiong.corelog.BaseTree
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class DBLogTree(context: Context) : BaseTree(context) {
    private val dao: LogDao

    init {
        dao = LogDataBase.getDatabase(context).logDao()
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, tag, message, t)
        if (priority == android.util.Log.VERBOSE) {
            return
        }
        val job = MainScope()
        kotlin.runCatching {
            val log = Log.create(priority, tag, message)
            job.launch {
                dao.insert(log)
                job.cancel()
            }
        }.onFailure {
            job.cancel()
        }
    }
}