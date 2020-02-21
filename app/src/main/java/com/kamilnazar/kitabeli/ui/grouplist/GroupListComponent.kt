package com.kamilnazar.kitabeli.ui.grouplist

import dagger.Subcomponent

@GroupListScope
@Subcomponent(modules = [GroupListModule::class])
interface GroupListComponent {
    fun inject(activity: GroupListActivity)
}