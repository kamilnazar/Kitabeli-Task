package com.kamilnazar.kitabeli.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Payload(
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "expireAt")
    val expireAt: Int? = null,
    @Json(name = "groupMemberIds")
    val groupMemberIds: List<Int?>? = null,
    @Json(name = "groupPrice")
    val groupPrice: Int? = null,
    @Json(name = "itemDTO")
    val itemDTO: ItemDTO? = null,
    @Json(name = "itemGroupId")
    val itemGroupId: Int? = null,
    @Json(name = "itemId")
    val itemId: Int? = null,
    @Json(name = "itemPrice")
    val itemPrice: Int? = null,
    @Json(name = "leaderAvatar")
    val leaderAvatar: String? = null,
    @Json(name = "leaderId")
    val leaderId: Int? = null,
    @Json(name = "leaderName")
    val leaderName: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "userNames")
    val userNames: List<String?>? = null
)