package dev.martincaux.property.list.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import co.touchlab.kermit.Logger
import dev.martincaux.core.theme.RealEstateTheme
import dev.martincaux.core.theme.spacing
import dev.martincaux.core.utils.formatArea
import dev.martincaux.core.utils.formatPrice
import dev.martincaux.property.common.compose.LoadingPropertyCard
import dev.martincaux.property.common.compose.PropertyItemCard
import dev.martincaux.property.common.uimodel.PropertyItemUi
import dev.martincaux.property.list.presentation.uimodel.PropertyListUi

@Composable
fun List(
    modifier: Modifier = Modifier,
    propertyList: PropertyListUi? = null,
    isLoading: Boolean = false,
    onItemClick: (Int) -> Unit
) {
    val listState = rememberLazyListState()
    val shouldShowShadow by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 || listState.firstVisibleItemScrollOffset > 0
        }
    }
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(spacing.medium)) {
        if (isLoading) ListHeaderLoading()
        else propertyList?.propertyCount?.let { propertyCount ->
            ListHeader(propertyCount = propertyCount, showShadow = shouldShowShadow)
        }
        LazyColumn(
            state = listState
        ) {
            if (isLoading) {
                items(5) {
                    LoadingPropertyCard()
                }
            } else {
                propertyList?.properties?.let { properties ->
                    items(properties) { item ->
                        PropertyItemCard(property = item, onClick = {
                            onItemClick(item.id)
                        })
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PropertyListPreview() {
    RealEstateTheme {
        List(
            propertyList = PropertyListUi(
                properties = listOf(
                    PropertyItemUi(
                        bedrooms = 3,
                        city = "Paris",
                        id = 1,
                        area = 100.00,
                        formattedArea = formatArea(100.00, logger = Logger),
                        imageUrl = "https://i.pinimg.com/originals/70/0a/5a/700a5a78999941b8081a231144309350.jpg",
                        price = 500000.00,
                        formattedPrice = formatPrice(500000.00, logger = Logger),
                        professional = "Real Estate Agency",
                        propertyType = "Apartment",
                        offerType = 1,
                        rooms = 5
                    ), PropertyItemUi(
                        bedrooms = 2,
                        city = "Lyon",
                        id = 2,
                        area = 75.5,
                        formattedArea = formatArea(75.5, Logger),
                        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Lyon_-_Quais_du_Rh%C3%B4ne_-_Vue_vers_le_nord.jpg/1280px-Lyon_-_Quais_du_Rh%C3%B4ne_-_Vue_vers_le_nord.jpg",
                        price = 350000.0,
                        formattedPrice = formatPrice(350000.0, Logger),
                        professional = "Independent Agent",
                        propertyType = "House",
                        offerType = 2,
                        rooms = 4
                    )
                ), 3
            )
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun PropertyListLoadingPreview() {
    RealEstateTheme {
        List(isLoading = true) { }
    }
}