package dev.martincaux.property.common.compose


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.martincaux.core.components.shimmerBrush
import dev.martincaux.core.theme.RealEstateTheme
import dev.martincaux.core.theme.spacing

@Composable
fun PropertyCardLoading(modifier: Modifier = Modifier) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4 / 3f)
                .background(shimmerBrush())
        )
        Column(modifier = modifier.padding(spacing.large)) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(30.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(shimmerBrush())
            )
            Spacer(modifier = Modifier.height(spacing.large))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(24.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(shimmerBrush())
            )
            Spacer(modifier = Modifier.height(spacing.medium))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(shimmerBrush())
            )
            Spacer(modifier = Modifier.height(spacing.medium))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(shimmerBrush())
            )
            Spacer(modifier = Modifier.height(spacing.medium))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(shimmerBrush())
            )
            Spacer(modifier = Modifier.height(spacing.medium))
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(shimmerBrush())
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPlaceholderPreview() {
    RealEstateTheme {
        PropertyCardLoading()
    }
}