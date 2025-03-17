package dev.martincaux.property.detail.presentation.mapper

import co.touchlab.kermit.Logger
import dev.martincaux.property.common.uimodel.PropertyDetailUi
import dev.martincaux.property.detail.domain.model.DetailDomain

fun DetailDomain.toUi(): PropertyDetailUi = PropertyDetailUi(
    id = id,
    city = city,
    area = area,
    formattedArea = dev.martincaux.core.utils.formatArea(area, Logger),
    price = price,
    formattedPrice = dev.martincaux.core.utils.formatPrice(price, Logger),
    professional = professional,
    propertyType = propertyType,
    offerType = offerType,
    rooms = rooms,
    imageUrl = imageUrl,
    bedrooms = bedrooms
)