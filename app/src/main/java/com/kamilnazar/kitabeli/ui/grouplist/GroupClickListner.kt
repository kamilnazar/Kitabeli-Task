package com.kamilnazar.kitabeli.ui.grouplist

interface GroupClickListner {
    fun groupDetail(groupId: Int?)
    fun joinGroup(groupId: Int?, quantity: Int?)
}