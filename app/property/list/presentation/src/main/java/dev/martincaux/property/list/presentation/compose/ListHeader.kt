package dev.martincaux.property.list.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.martincaux.core.theme.Theme
import dev.martincaux.core.theme.spacing

@Composable
fun ListHeader(propertyCount: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Properties", style = Theme.typography.titleLarge, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(spacing.small))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "$propertyCount properties", style = Theme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PropertyListHeaderPreview() {
    ListHeader(propertyCount = 123)
}