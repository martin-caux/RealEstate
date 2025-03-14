package dev.martincaux.core.navigation

sealed class Route(val route: String) {
    data object RealEstateList : Route("RealEstateList")
    data object RealEstateDetail : Route("RealEstateDetail/{itemId}") {
        fun createRoute(itemId: Int): String {
            return "RealEstateDetail/$itemId"
        }
    }
}