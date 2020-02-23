package com.kamilnazar.kitabeli.di.component

import com.kamilnazar.kitabeli.App
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.kamilnazar.kitabeli.di.modules.AppModule
import com.kamilnazar.kitabeli.di.modules.DbModule
import com.kamilnazar.kitabeli.di.modules.NetworkModule
import com.kamilnazar.kitabeli.di.modules.RepoModule
import com.kamilnazar.kitabeli.ui.groupdetail.GroupDetailComponent
import com.kamilnazar.kitabeli.ui.groupdetail.GroupDetailModule
import com.kamilnazar.kitabeli.ui.grouplist.GroupListComponent
import com.squareup.moshi.Moshi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DbModule::class, NetworkModule::class, RepoModule::class])
interface AppComponent {
    fun inject(app: App)
    fun moshi(): Moshi
    fun groupRepo(): GroupRepository
    // Subcomponent
    fun groupListComponent(): GroupListComponent

    fun groupDetailComponent(groupDetailModule: GroupDetailModule): GroupDetailComponent
}