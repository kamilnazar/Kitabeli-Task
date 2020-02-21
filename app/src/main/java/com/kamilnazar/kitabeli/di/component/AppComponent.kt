package com.kamilnazar.kitabeli.di.component

import com.kamilnazar.kitabeli.App
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.kamilnazar.kitabeli.di.modules.NetworkModule
import com.kamilnazar.kitabeli.di.modules.RepoModule
import com.kamilnazar.kitabeli.ui.grouplist.GroupListComponent
import com.kamilnazar.kitabeli.ui.grouplist.GroupListModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepoModule::class])
interface AppComponent {
    fun inject(app: App)
    fun groupRepo(): GroupRepository
    // Subcomponent
    fun get(module: GroupListModule): GroupListComponent
}