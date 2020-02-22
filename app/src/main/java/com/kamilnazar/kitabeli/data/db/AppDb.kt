package com.kamilnazar.kitabeli.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kamilnazar.kitabeli.data.convertor.ListTypeConvertor
import com.kamilnazar.kitabeli.data.dao.GroupDao
import com.kamilnazar.kitabeli.data.models.Payload
import com.squareup.moshi.Moshi

@Database(entities = [Payload::class], version = 1, exportSchema = false)
@TypeConverters(ListTypeConvertor::class)
abstract class AppDb : RoomDatabase() {
    abstract fun groupDao(): GroupDao

    companion object {
        lateinit var moshi: Moshi
    }
}