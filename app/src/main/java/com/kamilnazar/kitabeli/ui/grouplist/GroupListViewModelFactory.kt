package com.kamilnazar.kitabeli.ui.grouplist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@GroupListScope
class GroupListViewModelFactory @Inject constructor(private val repository: GroupRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GroupListViewModel(repository) as T
    }
}