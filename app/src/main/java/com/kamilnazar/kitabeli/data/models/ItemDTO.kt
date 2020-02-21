package com.kamilnazar.kitabeli.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemDTO(
    @Json(name = "breadcrumb")
    val breadcrumb: String? = null,
    @Json(name = "category")
    val category: String? = null,
    @Json(name = "description")
    val description: Description? = null,
    @Json(name = "groupPrice")
    val groupPrice: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "images")
    val images: List<String?>? = null,
    @Json(name = "inStock")
    val inStock: Boolean? = null,
    @Json(name = "itemCondition")
    val itemCondition: String? = null,
    @Json(name = "itemUrl")
    val itemUrl: String? = null,
    @Json(name = "merchantItemSold")
    val merchantItemSold: String? = null,
    @Json(name = "merchantSuccessTransaction")
    val merchantSuccessTransaction: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "price")
    val price: Int? = null,
    @Json(name = "quantity")
    val quantity: Int? = null,
    @Json(name = "rating")
    val rating: String? = null,
    @Json(name = "ratingCount")
    val ratingCount: Int? = null,
    @Json(name = "sellerLocation")
    val sellerLocation: String? = null,
    @Json(name = "sellerName")
    val sellerName: String? = null,
    @Json(name = "soloPrice")
    val soloPrice: Int? = null,
    @Json(name = "trending")
    val trending: Int? = null,
    @Json(name = "unitSize")
    val unitSize: String? = null
)