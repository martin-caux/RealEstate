package dev.martincaux.property.list.data.response

import com.squareup.moshi.Json

data class ListResponse(
    @Json(name = "items") val itemsList: List<ListItemDTO>?,
    @Json(name = "totalCount") val totalCount: Int?
)

data class ListItemDTO(
    val bedrooms: Int?,
    val city: String?,
    val id: Int?,
    val area: Double?,
    val url: String?,
    val price: Double?,
    val professional: String?,
    val propertyType: String?,
    val offerType: Int?,
    val rooms: Int?
)