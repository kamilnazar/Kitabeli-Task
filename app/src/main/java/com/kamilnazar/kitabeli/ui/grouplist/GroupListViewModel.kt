package com.kamilnazar.kitabeli.ui.grouplist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kamilnazar.kitabeli.data.models.Payload
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.kamilnazar.kitabeli.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GroupListViewModel(private val groupRepository: GroupRepository) : BaseViewModel() {

    val groups: MutableLiveData<List<Payload>> = MutableLiveData()
    fun loadGroups() {
        viewModelScope.launch {
            val g = withContext(IO) { groupRepository.allGroups() }
            groups.postValue(g)
        }
    }
}