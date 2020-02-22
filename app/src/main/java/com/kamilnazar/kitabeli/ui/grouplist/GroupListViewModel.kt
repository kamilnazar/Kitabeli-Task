package com.kamilnazar.kitabeli.ui.grouplist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kamilnazar.kitabeli.data.models.Payload
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.kamilnazar.kitabeli.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class GroupListViewModel(private val groupRepository: GroupRepository) : BaseViewModel() {

    val groups: MutableLiveData<List<Payload>> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = MutableLiveData(true)
    fun loadGroups() {
        viewModelScope.launch {
            try {
                loading.postValue(true)
                val g = withContext(IO) { groupRepository.allGroups() }
                groups.postValue(g)
            } catch (e: IOException) {
            } finally {
                loading.postValue(false)
            }
        }
    }
}