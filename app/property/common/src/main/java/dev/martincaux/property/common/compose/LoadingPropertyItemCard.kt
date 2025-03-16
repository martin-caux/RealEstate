package dev.martincaux.property.common.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.martincaux.core.components.shimmerBrush
import dev.martincaux.core.theme.RealEstateTheme
import dev.martincaux.core.theme.spacing

@Composable
fun LoadingPropertyCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = spacing.large,
                vertical = spacing.medium
            )
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(spacing.large)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(shimmerBrush())
        )
        Spacer(modifier = Modifier.height(spacing.large))
        Spacer(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(24.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(shimmerBrush())
        )
        Spacer(modifier = Modifier.height(spacing.medium))
        Spacer(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(20.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(shimmerBrush())
        )
        Spacer(modifier = Modifier.height(spacing.medium))
        Spacer(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .height(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(shimmerBrush())
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyPropertyCardPreview() {
    RealEstateTheme {
        LoadingPropertyCard()
    }
}