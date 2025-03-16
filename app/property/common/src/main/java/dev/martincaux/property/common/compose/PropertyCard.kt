package dev.martincaux.property.common.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.martincaux.core.theme.RealEstateTheme
import dev.martincaux.core.theme.Theme
import dev.martincaux.core.theme.spacing
import dev.martincaux.core.utils.anyNotNull
import dev.martincaux.property.common.R
import dev.martincaux.property.common.uimodel.PropertyItemUi

@Composable
fun PropertyCard(property: PropertyItemUi) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(property.imageUrl)
                .crossfade(true).build(),
            contentDescription = "Property Image",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.property_background_placeholder),
            error = painterResource(id = R.drawable.property_background_placeholder),
            modifier = Modifier.fillMaxWidth().aspectRatio(4/3f)
        )
        Column(modifier = Modifier.padding(spacing.large)) {
            Text(
                text = property.city,
                style = Theme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(spacing.medium))
            Text(
                text = property.formattedPrice,
                style = Theme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(spacing.medium))

            anyNotNull(property.bedrooms, property.rooms) { bedrooms, rooms ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    bedrooms?.let {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_bed_24),
                            contentDescription = "Bedrooms",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(spacing.small))
                        Text(text = "${property.bedrooms} bedrooms")
                        property.rooms?.let {
                            Spacer(modifier = Modifier.width(spacing.large))
                        }
                    }
                    rooms?.let {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_room_24),
                            contentDescription = "Rooms",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(spacing.small))
                        Text(text = "${property.rooms} rooms")
                    }
                }
                Spacer(modifier = Modifier.height(spacing.medium))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_area_24),
                    contentDescription = "Area",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(spacing.small))
                Text(text = property.formattedArea)
            }
            Spacer(modifier = Modifier.height(spacing.medium))
            Text(
                text = property.professional, style = Theme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(spacing.medium))
            Text(
                text = property.propertyType, style = Theme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailItemCardPreview() {
    RealEstateTheme {
        PropertyCard(
            property = PropertyItemUi(
                bedrooms = 3,
                city = "Paris",
                id = 1,
                area = 100.00,
                formattedArea = "100 m²",
                imageUrl = "https://i.pinimg.com/originals/70/0a/5a/700a5a78999941b8081a231144309350.jpg",
                price = 500000.00,
                formattedPrice = "500,000 €",
                professional = "Real Estate Agency",
                propertyType = "Apartment",
                offerType = 2,
                rooms = 5
            )
        )
    }
}