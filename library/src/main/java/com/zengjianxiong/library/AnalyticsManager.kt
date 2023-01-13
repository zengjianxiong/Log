package com.zengjianxiong.library

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
        fun getInstance(context: Context): AnalyticsManager =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildInstance(context).also { INSTANCE = it }
            }

        private fun buildInstance(context: Context): AnalyticsManager {
            CrashReporterExceptionHandler.init()
            if (BuildConfig.DEBUG) {
                Timber.plant(Timber.DebugTree())
                Timber.plant(FileLoggingTree(context))
            } else {
                Timber.plant(FileLoggingTree(context))
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