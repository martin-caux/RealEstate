package dev.martincaux.property.detail.presentation.mapper

import android.content.Context
import co.touchlab.kermit.Logger
import dev.martincaux.property.common.uimodel.PropertyItemUi
import dev.martincaux.property.detail.domain.model.DetailDomain

fun DetailDomain.toUi(context: Context): PropertyItemUi = PropertyItemUi(
    id = id,
    city = city,
    area = area,
    formattedArea = dev.martincaux.core.utils.formatArea(area, Logger, context),
    price = price,
    formattedPrice = dev.martincaux.core.utils.formatPrice(price, Logger),
    professional = professional,
    propertyType = propertyType,
    offerType = offerType,
    rooms = rooms,
    imageUrl = imageUrl,
    bedrooms = bedrooms
)