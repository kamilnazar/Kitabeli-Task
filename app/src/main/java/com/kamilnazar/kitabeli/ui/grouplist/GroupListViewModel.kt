package com.kamilnazar.kitabeli.ui.grouplist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kamilnazar.kitabeli.data.repository.GroupRepository
import com.kamilnazar.kitabeli.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException

class GroupListViewModel(private val groupRepository: GroupRepository) : BaseViewModel() {

    val groups = groupRepository.allGroups()
    val loading: MutableLiveData<Boolean> = MutableLiveData(true)
    fun loadGroups() {
        viewModelScope.launch {
            try {
                loading.postValue(true)
                withContext(IO) {
                    groupRepository.loadFromApi()
                }
            } catch (e: IOException) {
                Timber.e(e)
            } finally {
                loading.postValue(false)
            }
        }
    }
}