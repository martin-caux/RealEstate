package dev.martincaux.property.list.presentation.uimodel

import dev.martincaux.property.common.uimodel.PropertyItemUi

data class PropertyListUi(
    val properties: List<PropertyItemUi>, val propertyCount: Int
)