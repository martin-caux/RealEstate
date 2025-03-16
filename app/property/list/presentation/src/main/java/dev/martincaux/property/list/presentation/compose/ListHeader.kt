package dev.martincaux.property.list.presentation.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.martincaux.core.theme.Theme
import dev.martincaux.core.theme.spacing

@Composable
fun ListHeader(propertyCount: Int, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = spacing.large),
        text = "$propertyCount properties", style = Theme.typography.bodyLarge
    )
}

@Preview(showBackground = true)
@Composable
fun PropertyListHeaderPreview() {
    ListHeader(propertyCount = 123)
}