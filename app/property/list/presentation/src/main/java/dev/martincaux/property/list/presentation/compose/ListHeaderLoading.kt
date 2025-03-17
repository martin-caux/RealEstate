package dev.martincaux.property.list.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
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
import dev.martincaux.core.theme.spacing

@Composable
fun ListHeaderLoading(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .fillMaxWidth(0.4f)
            .padding(horizontal = spacing.large, vertical = spacing.medium)
            .height(20.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(shimmerBrush())
    )
}

@Preview(showBackground = true)
@Composable
fun PropertyListLoadingHeaderPreview() {
    ListHeaderLoading()
}