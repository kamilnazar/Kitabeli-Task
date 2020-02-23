package com.kamilnazar.kitabeli.ui.groupdetail

import com.kamilnazar.kitabeli.data.repository.GroupRepository
import dagger.Module
import dagger.Provides

@Module
class GroupDetailModule(private val groupId: Int) {
    @Provides
    @GroupDetailScope
    fun providesVmFactory(groupRepository: GroupRepository) =
        GroupDetailViewModelFactory(groupId, groupRepository)
}