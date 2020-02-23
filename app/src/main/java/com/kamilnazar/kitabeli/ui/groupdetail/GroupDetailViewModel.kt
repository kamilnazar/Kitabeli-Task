package com.kamilnazar.kitabeli.ui.groupdetail

import androidx.lifecycle.MutableLiveData
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.kamilnazar.kitabeli.ui.base.BaseViewModel

class GroupDetailViewModel(private val groupid: Int, private val groupRepository: GroupRepository) :
    BaseViewModel() {

    val group = groupRepository.groupById(groupid)
    val totalPrice = MutableLiveData(0)

    var quantity = 0
        set(value) {
            field = value
            val payload = group.value
            val price = (payload?.groupPrice ?: 0) * value
            totalPrice.postValue(price)
        }


}