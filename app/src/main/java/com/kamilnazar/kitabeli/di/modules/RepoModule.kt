package com.kamilnazar.kitabeli.di.modules

import com.kamilnazar.kitabeli.data.repository.GroupRepoImpl
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module

class RepoModule {
    @Singleton
    @Provides
    fun provideGroupRepo(groupRepoImpl: GroupRepoImpl): GroupRepository = groupRepoImpl
}