package dev.martincaux.property.list.presentation.mapper

import android.content.Context
import co.touchlab.kermit.Logger
import dev.martincaux.core.utils.formatArea
import dev.martincaux.core.utils.formatPrice
import dev.martincaux.property.common.uimodel.PropertyItemUi
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.model.PropertyItemDomain
import dev.martincaux.property.list.presentation.uimodel.PropertyListUi

fun ListDomain.toUi(context: Context): PropertyListUi = PropertyListUi(
    properties = properties.map { it.toUi(context) }, propertyCount = propertyCount
)

fun PropertyItemDomain.toUi(context: Context): PropertyItemUi = PropertyItemUi(
    id = id,
    city = city,
    area = area,
    formattedArea = formatArea(area, Logger, context),
    price = price,
    formattedPrice = formatPrice(price, Logger),
    professional = professional,
    propertyType = propertyType,
    offerType = offerType,
    rooms = rooms,
    imageUrl = imageUrl,
    bedrooms = bedrooms
)