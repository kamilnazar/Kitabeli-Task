package com.kamilnazar.kitabeli.data.api

import com.kamilnazar.kitabeli.data.models.Response
import retrofit2.http.GET

interface KitabeliApi {
    @GET("group/test/")
    suspend fun payloads(): Response
}