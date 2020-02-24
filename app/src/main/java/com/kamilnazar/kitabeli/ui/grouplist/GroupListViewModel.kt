package com.kamilnazar.kitabeli.ui.grouplist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.kamilnazar.kitabeli.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class GroupListViewModel(private val groupRepository: GroupRepository) : BaseViewModel() {

    val groups = groupRepository.allGroups()
    val loading: MutableLiveData<Boolean> = MutableLiveData(true)
    val error: MutableLiveData<Boolean> = MutableLiveData()
    fun loadGroups() {
        viewModelScope.launch {
            try {
                loading.postValue(true)
                withContext(IO) {
                    groupRepository.loadFromApi()
                }
            } catch (e: Exception) {
                Timber.e(e)
                error.postValue(true)
            } finally {
                loading.postValue(false)
            }
        }
    }
}