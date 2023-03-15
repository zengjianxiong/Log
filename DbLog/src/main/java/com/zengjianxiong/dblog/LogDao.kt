package com.zengjianxiong.dblog

import androidx.room.Dao
import androidx.room.Query
import com.zengjianxiong.dblog.BaseDao
import com.zengjianxiong.dblog.Log
import java.util.*

@Dao
interface LogDao : BaseDao<Log> {
//    @Query("select * from Log where createAt < :date")
//    suspend fun queryOverdueLogs(date: Date): List<Log>


    @Query("delete from Log where createAt < :date")
    suspend fun deleteOverdueLogs(date: Date)
}