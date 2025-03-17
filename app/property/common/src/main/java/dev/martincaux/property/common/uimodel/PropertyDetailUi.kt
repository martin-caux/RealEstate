package dev.martincaux.property.common.uimodel

data class PropertyDetailUi(
    val city: String,
    val id: Int,
    val area: Double,
    val formattedArea: String,
    val price: Double,
    val formattedPrice: String,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
    val bedrooms: Int?,
    val rooms: Int?,
    val imageUrl: String?
)