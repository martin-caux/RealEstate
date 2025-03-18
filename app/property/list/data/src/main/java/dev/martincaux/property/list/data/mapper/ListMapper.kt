package dev.martincaux.property.list.data.mapper

import dev.martincaux.property.list.data.response.ListResponse
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.model.PropertyItemDomain

class ListMapper {

    fun map(response: ListResponse): ListDomain {
        val propertyList = response.itemsList?.mapNotNull {
            PropertyItemDomain(
                city = it.city ?: return@mapNotNull null,
                id = it.id ?: return@mapNotNull null,
                area = it.area ?: return@mapNotNull null,
                price = it.price ?: return@mapNotNull null,
                professional = it.professional ?: return@mapNotNull null,
                propertyType = it.propertyType ?: return@mapNotNull null,
                offerType = it.offerType ?: return@mapNotNull null,
                bedrooms = it.bedrooms,
                rooms = it.rooms,
                imageUrl = it.url
            )
        } ?: emptyList()

        return ListDomain(
            properties = propertyList,
            propertyCount = if(response.totalCount == propertyList.size) response.totalCount else propertyList.size
        )
    }
}