package com.kamilnazar.kitabeli.data.models


import androidx.room.*
import com.kamilnazar.kitabeli.data.convertor.ListTypeConvertor
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "groups")
@JsonClass(generateAdapter = true)
data class Payload(
    @PrimaryKey(autoGenerate = true) @ColumnInfo @Transient var id: Int = 0,
    @Json(name = "category")
    var category: String? = null,
    @Json(name = "expireAt")
    var expireAt: Long? = null,
    @Json(name = "groupMemberIds")
    @TypeConverters(ListTypeConvertor::class)
    var groupMemberIds: List<Int?>? = null,
    @Json(name = "groupPrice")
    var groupPrice: Int? = null,
    @Json(name = "itemDTO")
    @Embedded(prefix = "item_dto_")
    var itemDTO: ItemDTO? = null,
    @Json(name = "itemGroupId")
    var itemGroupId: Int? = null,
    @Json(name = "itemId")
    var itemId: Int? = null,
    @Json(name = "itemPrice")
    var itemPrice: Int? = null,
    @Json(name = "leaderAvatar")
    var leaderAvatar: String? = null,
    @Json(name = "leaderId")
    var leaderId: Int? = null,
    @Json(name = "leaderName")
    var leaderName: String? = null,
    @Json(name = "type")
    var type: String? = null,
    @Json(name = "userNames")
    @TypeConverters(ListTypeConvertor::class)
    var userNames: List<String?>? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Payload

        if (category != other.category) return false
        if (expireAt != other.expireAt) return false
        if (groupMemberIds != other.groupMemberIds) return false
        if (groupPrice != other.groupPrice) return false
        if (itemDTO != other.itemDTO) return false
        if (itemGroupId != other.itemGroupId) return false
        if (itemId != other.itemId) return false
        if (itemPrice != other.itemPrice) return false
        if (leaderAvatar != other.leaderAvatar) return false
        if (leaderId != other.leaderId) return false
        if (leaderName != other.leaderName) return false
        if (type != other.type) return false
        if (userNames != other.userNames) return false

        return true
    }

    override fun hashCode(): Int {
        var result = category?.hashCode() ?: 0
        result = 31 * result + (expireAt?.hashCode() ?: 0)
        result = 31 * result + (groupMemberIds?.hashCode() ?: 0)
        result = 31 * result + (groupPrice ?: 0)
        result = 31 * result + (itemDTO?.hashCode() ?: 0)
        result = 31 * result + (itemGroupId ?: 0)
        result = 31 * result + (itemId ?: 0)
        result = 31 * result + (itemPrice ?: 0)
        result = 31 * result + (leaderAvatar?.hashCode() ?: 0)
        result = 31 * result + (leaderId ?: 0)
        result = 31 * result + (leaderName?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (userNames?.hashCode() ?: 0)
        return result
    }
}