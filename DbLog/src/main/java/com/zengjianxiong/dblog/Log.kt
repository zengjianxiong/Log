package com.zengjianxiong.dblog

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Entity
@Parcelize
data class Log(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val threadName: String,
    val time: String,
    val createAt: Date,
    val priority: String,
    val tag: String?,
    val message: String
) : Parcelable {

    companion object {
        private val SDF_THREAD_LOCAL = ThreadLocal<SimpleDateFormat>()

        fun create(priority: Int, tag: String?, message: String): Log {
            val calendar = Calendar.getInstance()
            val date = calendar.time
            val time = getDefaultFormat().format(date)
            return Log(
                threadName = Thread.currentThread().name,
                time = time,
                createAt = date,
                priority = priorityString(priority),
                tag = tag ?: "",
                message = message
            )
        }

        private fun priorityString(priority: Int): String {
            return when (priority) {
                android.util.Log.VERBOSE -> "VERBOSE"
                android.util.Log.DEBUG -> "DEBUG"
                android.util.Log.INFO -> "INFO"
                android.util.Log.WARN -> "WARN"
                android.util.Log.ERROR -> "ERROR"
                android.util.Log.ASSERT -> "ASSERT"
                else -> "UNKNOWN"
            }
        }

        private fun getDefaultFormat(): SimpleDateFormat {
            var simpleDateFormat: SimpleDateFormat? = SDF_THREAD_LOCAL.get()
            if (simpleDateFormat == null) {
                simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss", Locale.getDefault())
                SDF_THREAD_LOCAL.set(simpleDateFormat)
            }
            return simpleDateFormat
        }
    }
}