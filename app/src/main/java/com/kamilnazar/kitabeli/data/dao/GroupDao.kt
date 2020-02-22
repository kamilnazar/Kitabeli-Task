package com.kamilnazar.kitabeli.data.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kamilnazar.kitabeli.data.models.Payload

@Dao
interface GroupDao {
    @Insert
    suspend fun insertAll(allGroups: List<Payload>)

    @Query("select * from groups")
    fun allGroups(): DataSource.Factory<Int, Payload>

    @Query("delete from groups")
    suspend fun deleteAllGroups()
}