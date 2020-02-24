package com.kamilnazar.kitabeli.ui.grouplist

import com.kamilnazar.kitabeli.data.models.Payload

interface GroupClickListner {
    fun groupDetail(groupId: Int?)
    fun joinGroup(groupId: Int?, quantity: Int?)
    fun shareGroup(payload: Payload?)
}