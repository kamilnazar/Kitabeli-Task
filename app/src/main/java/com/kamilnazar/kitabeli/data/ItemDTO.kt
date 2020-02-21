package com.kamilnazar.kitabeli.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemDTO(
    @Json(name = "breadcrumb")
    val breadcrumb: String,
    @Json(name = "category")
    val category: String,
    @Json(name = "description")
    val description: Description,
    @Json(name = "groupPrice")
    val groupPrice: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "images")
    val images: List<String>,
    @Json(name = "inStock")
    val inStock: Boolean,
    @Json(name = "itemCondition")
    val itemCondition: String,
    @Json(name = "itemUrl")
    val itemUrl: String,
    @Json(name = "merchantItemSold")
    val merchantItemSold: String,
    @Json(name = "merchantSuccessTransaction")
    val merchantSuccessTransaction: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: Int,
    @Json(name = "quantity")
    val quantity: Int,
    @Json(name = "rating")
    val rating: String,
    @Json(name = "ratingCount")
    val ratingCount: Int,
    @Json(name = "sellerLocation")
    val sellerLocation: String,
    @Json(name = "sellerName")
    val sellerName: String,
    @Json(name = "soloPrice")
    val soloPrice: Int,
    @Json(name = "trending")
    val trending: Int,
    @Json(name = "unitSize")
    val unitSize: String
)