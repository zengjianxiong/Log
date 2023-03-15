package com.zengjianxiong.dblog

import androidx.room.*

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: T)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(obj: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateList(obj: List<T>)

    @Delete
    suspend fun delete(obj: T)

    @Delete
    suspend fun deleteList(list: List<T>)

}