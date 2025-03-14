package dev.martincaux.property.detail.domain.model

data class DetailDomain(
    val id: Int,
    val city: String,
    val area: Double,
    val price: Double,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
    val bedrooms: Int? = null,
    val rooms: Int? = null,
    val imageUrl: String? = null
)