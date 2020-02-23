package com.kamilnazar.kitabeli.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.kamilnazar.kitabeli.data.api.KitabeliApi
import com.kamilnazar.kitabeli.data.dao.GroupDao
import com.kamilnazar.kitabeli.data.models.Payload
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GroupRepoImpl @Inject constructor(
    private val api: KitabeliApi,
    private val groupDao: GroupDao
) : GroupRepository {
    override fun allGroups(): LiveData<PagedList<Payload>> {
        return groupDao.allGroups().toLiveData(10)
    }

    override suspend fun loadFromApi() {
        val list = api.payloads().payload ?: listOf()
        groupDao.deleteAllGroups()
        groupDao.insertAll(list)
    }

    override fun groupById(id: Int): LiveData<Payload?> {
        return groupDao.groupBy(id)
    }
}