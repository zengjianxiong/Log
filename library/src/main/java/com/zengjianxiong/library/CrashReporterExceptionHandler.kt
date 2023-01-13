package com.zengjianxiong.library

class CrashReporterExceptionHandler : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        AppLogUtils.e(throwable)
    }


    companion object {
        fun init() {
            val handler = CrashReporterExceptionHandler()
            Thread.setDefaultUncaughtExceptionHandler(handler)
        }
    }
}