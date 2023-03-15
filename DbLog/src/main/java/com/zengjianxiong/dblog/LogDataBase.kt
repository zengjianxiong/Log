package com.zengjianxiong.dblog

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(
    version = 2,
    exportSchema = true,
    entities = [Log::class]
)
@TypeConverters(Converters::class)
abstract class LogDataBase : RoomDatabase() {
    abstract fun logDao(): LogDao


    companion object {
        @Volatile
        private var INSTANCE: LogDataBase? = null

        const val db_name = "log.db"
        fun getDatabase(context: Context): LogDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    LogDataBase::class.java,
                    db_name
                ).addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                instance
            }
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Log ADD COLUMN createAt INTEGER NOT NULL DEFAULT 0")
            }
        }
    }
}