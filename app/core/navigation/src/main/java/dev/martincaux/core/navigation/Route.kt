package dev.martincaux.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Route(val route: String) {
    @Serializable
    data object RealEstateList : Route("RealEstateList")
    @Serializable
    data object RealEstateDetail : Route("RealEstateDetail/{itemId}") {
        fun createRoute(itemId: Int): String {
            return "RealEstateDetail/$itemId"
        }
    }
}