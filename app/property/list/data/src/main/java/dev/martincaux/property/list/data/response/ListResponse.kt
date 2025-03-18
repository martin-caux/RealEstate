package dev.martincaux.property.list.data.response

import com.squareup.moshi.Json

data class ListResponse(
    @Json(name = "items") val itemsList: List<ListItemDTO>?,
    @Json(name = "totalCount") val totalCount: Int?
)

data class ListItemDTO(
    val bedrooms: Int? = null,
    val city: String? = null,
    val id: Int? = null,
    val area: Double? = null,
    val url: String? = null,
    val price: Double? = null,
    val professional: String? = null,
    val propertyType: String? = null,
    val offerType: Int? = null,
    val rooms: Int? = null
)