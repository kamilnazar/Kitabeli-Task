package com.kamilnazar.kitabeli.ui.groupdetail

import androidx.lifecycle.MutableLiveData
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.kamilnazar.kitabeli.ui.base.BaseViewModel

class GroupDetailViewModel(private val groupid: Int, private val groupRepository: GroupRepository) :
    BaseViewModel() {

    val group = groupRepository.groupById(groupid)
    val quantity = MutableLiveData(1)

    private var _quantity = 1

    fun incrementQuantity() {
        _quantity++
        quantity.value = _quantity
    }

    fun decrementQuantity() {
        if (_quantity > 1) {
            _quantity--
            quantity.value = _quantity
        }
    }
}