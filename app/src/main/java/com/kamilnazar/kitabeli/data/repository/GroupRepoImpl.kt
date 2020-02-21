package com.kamilnazar.kitabeli.data.repository

import com.kamilnazar.kitabeli.data.api.KitabeliApi
import com.kamilnazar.kitabeli.data.models.Payload
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GroupRepoImpl @Inject constructor(private val api: KitabeliApi) : GroupRepository {
    override suspend fun allGroups(): List<Payload> {
        return api.payloads().payload ?: listOf()
    }
}