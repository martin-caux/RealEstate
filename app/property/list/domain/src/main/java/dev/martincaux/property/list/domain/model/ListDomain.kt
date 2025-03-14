package dev.martincaux.property.list.domain.model

data class ListDomain(
    val properties: List<PropertyItemDomain>, val propertyCount: Int
)