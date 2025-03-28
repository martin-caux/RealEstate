package dev.martincaux.property.list.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.martincaux.core.theme.spacing
import dev.martincaux.core.values.R

@Composable
fun ListHeader(propertyCount: Int, modifier: Modifier = Modifier, showShadow: Boolean = false) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = if (showShadow) 4.dp else 0.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = spacing.large, vertical = spacing.medium),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = stringResource(R.string.property_count_value, propertyCount),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PropertyListHeaderPreview() {
    ListHeader(propertyCount = 123)
}