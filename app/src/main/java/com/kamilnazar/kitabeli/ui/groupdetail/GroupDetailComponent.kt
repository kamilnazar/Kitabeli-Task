package com.kamilnazar.kitabeli.ui.groupdetail

import dagger.Subcomponent

@GroupDetailScope
@Subcomponent(modules = [GroupDetailModule::class])
interface GroupDetailComponent {
    fun inject(groupDetailActivity: GroupDetailActivity)
}