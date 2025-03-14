package dev.martincaux.property.detail.data.mapper

import dev.martincaux.property.detail.data.response.DetailResponse
import dev.martincaux.property.detail.domain.model.DetailDomain

class DetailMapper {

    fun map(response: DetailResponse): DetailDomain? {
        return DetailDomain(
            city = response.city ?: return null,
            id = response.id ?: return null,
            area = response.area ?: return null,
            price = response.price ?: return null,
            professional = response.professional ?: return null,
            propertyType = response.propertyType ?: return null,
            offerType = response.offerType ?: return null,
            bedrooms = response.bedrooms,
            rooms = response.rooms,
            imageUrl = response.url
        )
    }
}