package com.kamilnazar.kitabeli.ui.cartdetail

import androidx.lifecycle.ViewModel
import com.kamilnazar.kitabeli.data.repository.GroupRepository

class CartViewModel(
    private val groudId: Int,
    private val quantity: Int,
    private val groupRepository: GroupRepository
) : ViewModel() {
    val group = groupRepository.groupById(groudId)
    var itemQuantity = 0
}