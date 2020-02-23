package com.kamilnazar.kitabeli.ui.cartdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kamilnazar.kitabeli.data.repository.GroupRepository

@Suppress("UNCHECKED_CAST")
class CartDetailViewModelFactory(
    private val groudId: Int,
    private val quantity: Int,
    private val groupRepository: GroupRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CartViewModel(groudId, quantity, groupRepository) as T
    }

}