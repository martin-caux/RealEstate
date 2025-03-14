package dev.martincaux.property.detail.data.response

data class DetailResponse(
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