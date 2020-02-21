package com.kamilnazar.kitabeli.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "code")
    val code: String? = null,
    @Json(name = "message")
    val message: String? = null,
    @Json(name = "payload")
    val payload: List<Payload>? = null
)