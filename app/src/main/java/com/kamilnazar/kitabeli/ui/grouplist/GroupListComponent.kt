package com.kamilnazar.kitabeli.ui.grouplist

import dagger.Subcomponent

@GroupListScope
@Subcomponent
interface GroupListComponent {
    fun inject(activity: GroupListActivity)
}