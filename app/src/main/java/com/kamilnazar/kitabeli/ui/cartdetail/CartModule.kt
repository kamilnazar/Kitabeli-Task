package com.kamilnazar.kitabeli.ui.cartdetail

import com.kamilnazar.kitabeli.data.repository.GroupRepository
import dagger.Module
import dagger.Provides

@Module
class CartModule(private val groupId: Int, private val quantity:Int) {
    @Provides
    @CartScope
    fun provideViewModelFactory(groupRepository: GroupRepository) =
        CartDetailViewModelFactory(groupId, quantity, groupRepository)
}