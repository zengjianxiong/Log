package com.zengjianxiong.dblog

import android.content.Context
import com.zengjianxiong.corelog.BaseTree
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class DBLogTree(context: Context) : BaseTree(context) {
    private val dao: LogDao
    private val job: CoroutineScope

    init {
        dao = LogDataBase.getDatabase(context).logDao()
        job = CoroutineScope(Dispatchers.IO)
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, tag, message, t)
        if (priority == android.util.Log.VERBOSE) {
            return
        }
        val log = Log.create(priority, tag, message)
        job.launch {
            kotlin.runCatching {
                dao.insert(log)
            }
        }
    }
}