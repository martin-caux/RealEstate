package dev.martincaux.property.list.presentation.mapper

import co.touchlab.kermit.Logger
import dev.martincaux.core.utils.formatArea
import dev.martincaux.core.utils.formatPrice
import dev.martincaux.property.common.uimodel.PropertyItemUi
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.model.PropertyItemDomain
import dev.martincaux.property.list.presentation.uimodel.PropertyListUi

fun ListDomain.toUi(): PropertyListUi =
    PropertyListUi(
        properties = properties.map { it.toUi() },
        propertyCount = propertyCount
    )

fun PropertyItemDomain.toUi(): PropertyItemUi =
    PropertyItemUi(
        id = id,
        city = city,
        area = area,
        formattedArea = formatArea(area, Logger),
        price = price,
        formattedPrice = formatPrice(price, Logger),
        professional = professional,
        propertyType = propertyType,
        offerType = offerType,
        rooms = rooms,
        imageUrl = imageUrl,
        bedrooms = bedrooms
    )