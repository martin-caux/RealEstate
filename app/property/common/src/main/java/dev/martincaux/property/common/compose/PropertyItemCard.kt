package dev.martincaux.property.common.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import coil.compose.AsyncImage
import dev.martincaux.core.theme.RealEstateTheme
import dev.martincaux.core.theme.Theme
import dev.martincaux.core.theme.spacing
import dev.martincaux.core.utils.formatArea
import dev.martincaux.core.utils.formatPrice
import dev.martincaux.property.common.R
import dev.martincaux.property.common.uimodel.PropertyItemUi

@Composable
fun PropertyItemCard(property: PropertyItemUi, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.medium)
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Column(modifier = Modifier.padding(spacing.large)) {
            AsyncImage(
                model = property.imageUrl,
                contentDescription = "Image of the property",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.property_background_placeholder),
                error = painterResource(id = R.drawable.property_background_placeholder)
            )
            Spacer(modifier = Modifier.height(spacing.medium))
            Row(verticalAlignment = Alignment.CenterVertically) {
                property.bedrooms?.let { bedrooms ->
                    Image(
                        painter = painterResource(id = R.drawable.baseline_bed_24),
                        contentDescription = "Bedrooms",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(spacing.small))
                    Text(
                        text = "$bedrooms bedrooms",
                        style = Theme.typography.bodyMedium,
                        color = Theme.colorScheme.onTertiaryContainer
                    )
                    property.rooms?.let { Spacer(modifier = Modifier.width(16.dp)) }
                }
                property.rooms?.let { rooms ->
                    Image(
                        painter = painterResource(id = R.drawable.baseline_room_24),
                        contentDescription = "Rooms",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(spacing.small))
                    Text(
                        text = "$rooms rooms",
                        style = Theme.typography.bodyMedium,
                        color = Theme.colorScheme.onTertiaryContainer
                    )
                }

            }
            Spacer(modifier = Modifier.height(spacing.medium))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_area_24),
                    contentDescription = "Area",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(spacing.small))
                Text(
                    text = property.formattedArea,
                    style = Theme.typography.bodyMedium,
                    color = Theme.colorScheme.onTertiaryContainer
                )
            }
            Spacer(modifier = Modifier.height(spacing.medium))
            Text(
                text = property.city,
                style = Theme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Theme.colorScheme.onTertiaryContainer
            )
            Spacer(modifier = Modifier.height(spacing.small))
            Text(
                text = property.formattedPrice,
                style = Theme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth(),
                color = Theme.colorScheme.onTertiaryContainer
            )
            Spacer(modifier = Modifier.height(spacing.small))
            Text(
                text = property.propertyType,
                style = Theme.typography.bodySmall,
                color = Theme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = property.professional,
                style = Theme.typography.bodySmall,
                color = Theme.colorScheme.tertiary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListingItemCardPreview() {
    val listing = PropertyItemUi(
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
    )
    RealEstateTheme {
        PropertyItemCard(property = listing)
    }
}