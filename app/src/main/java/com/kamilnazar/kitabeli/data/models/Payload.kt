package com.kamilnazar.kitabeli.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Payload(
    @Json(name = "category")
    val category: String,
    @Json(name = "expireAt")
    val expireAt: Int,
    @Json(name = "groupMemberIds")
    val groupMemberIds: List<Int>,
    @Json(name = "groupPrice")
    val groupPrice: Int,
    @Json(name = "itemDTO")
    val itemDTO: ItemDTO,
    @Json(name = "itemGroupId")
    val itemGroupId: Int,
    @Json(name = "itemId")
    val itemId: Int,
    @Json(name = "itemPrice")
    val itemPrice: Int,
    @Json(name = "leaderAvatar")
    val leaderAvatar: String,
    @Json(name = "leaderId")
    val leaderId: Int,
    @Json(name = "leaderName")
    val leaderName: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "userNames")
    val userNames: List<String>
)