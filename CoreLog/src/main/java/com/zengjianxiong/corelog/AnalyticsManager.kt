package com.zengjianxiong.corelog

import android.content.Context

import android.os.Environment
import timber.log.Timber
import java.io.File


class AnalyticsManager {
    companion object {
        const val LOG_PREFIX = "log"
        const val LATEST_LOG_ADDRESS = "$LOG_PREFIX-latest.log"

        @Volatile
        private var INSTANCE: AnalyticsManager? = null

        @JvmStatic
        fun getInstance(debug: Boolean, tree: BaseTree): AnalyticsManager =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildInstance(debug, tree).also { INSTANCE = it }
            }

        private fun buildInstance(
            debug: Boolean,
            tree: BaseTree
        ): AnalyticsManager {
            CrashReporterExceptionHandler.init()
            if (debug) {
                Timber.plant(Timber.DebugTree())
                Timber.plant(tree)
            } else {
                Timber.plant(tree)
            }

            return AnalyticsManager()
        }


        @JvmStatic
        fun getLogsDir(context: Context): File {
            val state = Environment.getExternalStorageState()
            val storageDir = if (Environment.MEDIA_MOUNTED == state) {
                // SD card (or partition) available
                context.getExternalFilesDir(null)
            } else {
                // Try internal storage
                context.filesDir
            }
            return File(storageDir, "/logs")
        }


        fun getLatestLogFile(context: Context): File {
            return File(
                getLogsDir(context),
                "/$LATEST_LOG_ADDRESS"
            )
        }

        @JvmStatic
        fun getLogPrefix(): String {
            return LOG_PREFIX
        }
    }
}