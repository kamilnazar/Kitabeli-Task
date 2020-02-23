package com.kamilnazar.kitabeli.di.modules

import android.content.Context
import androidx.room.Room
import com.kamilnazar.kitabeli.data.dao.GroupDao
import com.kamilnazar.kitabeli.data.db.AppDb
import com.kamilnazar.kitabeli.data.db.AppDb.Companion.moshi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    fun provideDb(context: Context, _moshi: Moshi) =
        Room.inMemoryDatabaseBuilder(context, AppDb::class.java)
            .build().apply { moshi = _moshi }

    @Provides
    @Singleton
    fun provideGroupDao(db: AppDb): GroupDao = db.groupDao()
}