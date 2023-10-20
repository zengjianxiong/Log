package com.zengjianxiong.filelog

import android.content.Context
import android.os.Looper
import android.util.Log
import ch.qos.logback.classic.Level
import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import ch.qos.logback.core.util.FileSize
import ch.qos.logback.core.util.FileSize.*
import ch.qos.logback.core.util.StatusPrinter
import com.zengjianxiong.corelog.AnalyticsManager
import com.zengjianxiong.corelog.AnalyticsManager.Companion.LATEST_LOG_ADDRESS
import com.zengjianxiong.corelog.AnalyticsManager.Companion.LOG_PREFIX
import com.zengjianxiong.corelog.BaseTree
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MarkerFactory


class FileLoggingTree(context: Context) : BaseTree(context) {
    companion object {
        internal var mLogger = LoggerFactory.getLogger(FileLoggingTree::class.java)
    }

    init {
        val logDirectory: String = AnalyticsManager.getLogsDir(context).absolutePath
        configureLogger(logDirectory)
    }


    private fun configureLogger(logDirectory: String) {
        // Reset the default context (which may already have been initialized)
        // Since we want to reconfigure it
        val loggerContext: LoggerContext = LoggerFactory.getILoggerFactory() as LoggerContext
        loggerContext.reset()
        val rollingFileAppender: RollingFileAppender<ILoggingEvent> = RollingFileAppender()
        rollingFileAppender.context = loggerContext
        rollingFileAppender.name = "Logger"
        rollingFileAppender.isAppend = true
        rollingFileAppender.file = "$logDirectory/$LATEST_LOG_ADDRESS"


        val fileNamingPolicy: SizeAndTimeBasedFNATP<ILoggingEvent> = SizeAndTimeBasedFNATP()
        fileNamingPolicy.context = loggerContext
        fileNamingPolicy.setMaxFileSize(FileSize(1 * MB_COEFFICIENT))

        val rollingPolicy: TimeBasedRollingPolicy<ILoggingEvent> = TimeBasedRollingPolicy()
        rollingPolicy.context = loggerContext
        rollingPolicy.fileNamePattern = "$logDirectory/$LOG_PREFIX.%d{yyyy-MM-dd}.%i.log"
        rollingPolicy.maxHistory = 15
        rollingPolicy.timeBasedFileNamingAndTriggeringPolicy = fileNamingPolicy
        rollingPolicy.setParent(rollingFileAppender) // parent and context required!
        rollingPolicy.isCleanHistoryOnStart = true
        rollingPolicy.setTotalSizeCap(FileSize(1024 * MB_COEFFICIENT))
        rollingPolicy.start()
        val encoder = PatternLayoutEncoder()
        encoder.context = loggerContext
        encoder.pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
        encoder.start()

        rollingFileAppender.rollingPolicy = rollingPolicy
        rollingFileAppender.encoder = encoder
        rollingFileAppender.start()

        // Add the newly created appenders to the root logger;
        // Qualify Logger to disambiguate from org.slf4j.Logger
        val root: ch.qos.logback.classic.Logger = LoggerFactory
            .getLogger(Logger.ROOT_LOGGER_NAME) as ch.qos.logback.classic.Logger
        root.level = Level.TRACE
        root.addAppender(rollingFileAppender)

        // Print any status messages (warnings, etc) encountered in logback config
        StatusPrinter.print(loggerContext)
    }

    private val WTF_MARKER = MarkerFactory.getMarker("WTF-")
    private fun logToFile(priority: Int, tag: String, message: String) {
        val logMessage = "$tag: $message"
        when (priority) {
            // No need to track debug logs in support file
            Log.VERBOSE -> mLogger.trace(logMessage)
            Log.DEBUG -> mLogger.debug(logMessage)
            Log.INFO -> mLogger.info(logMessage)
            Log.WARN -> mLogger.warn(logMessage)
            Log.ERROR -> mLogger.error(logMessage)
            Log.ASSERT -> mLogger.error(WTF_MARKER, logMessage)
        }
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        if (Looper.myLooper() == Looper.getMainLooper()) {
            val job = MainScope()
            kotlin.runCatching {
                job.launch {
                    logToFile(priority, tag ?: "", message)
                    job.cancel()
                }
            }.onFailure {
                job.cancel()
            }
        } else {
            logToFile(priority, tag ?: "", message)
        }


    }
}

