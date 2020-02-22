package com.kamilnazar.kitabeli.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.kamilnazar.kitabeli.data.models.Payload

interface GroupRepository {
    fun allGroups(): LiveData<PagedList<Payload>>
    suspend fun loadFromApi()
}