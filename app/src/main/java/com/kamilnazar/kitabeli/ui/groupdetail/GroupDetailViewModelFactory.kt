package com.kamilnazar.kitabeli.ui.groupdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class GroupDetailViewModelFactory(
    private val groupid: Int,
    private val groupRepository: GroupRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GroupDetailViewModel(groupid, groupRepository) as T
    }
}