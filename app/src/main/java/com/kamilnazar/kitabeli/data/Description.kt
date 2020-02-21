package com.kamilnazar.kitabeli.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Description(
    @Json(name = "description")
    val description: String,
    @Json(name = "tokopedia_url")
    val tokopediaUrl: String
)