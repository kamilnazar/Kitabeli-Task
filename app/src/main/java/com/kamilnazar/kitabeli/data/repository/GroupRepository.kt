package com.kamilnazar.kitabeli.data.repository

import com.kamilnazar.kitabeli.data.models.Payload

interface GroupRepository {
    suspend fun allGroups(): List<Payload>
}