package dev.martincaux.core.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.martincaux.core.theme.RealEstateTheme
import dev.martincaux.core.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onNavigateUp: (() -> Unit)? = null,
    isTransparent: Boolean = false
) {
    onNavigateUp?.let { action ->
        TopAppBar(title = {
            title?.let { titleValue ->
                Text(
                    text = titleValue,
                    style = Theme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }, navigationIcon = {
            IconButton(onClick = { action() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = if (isTransparent) Theme.colorScheme.onSurface else Theme.colorScheme.onBackground
                )
            }
        }, colors = if (isTransparent) TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            navigationIconContentColor = Theme.colorScheme.onSurface
        ) else TopAppBarDefaults.topAppBarColors()
        )
    } ?: run {
        CenterAlignedTopAppBar(modifier = modifier.background(Theme.colorScheme.primary), title = {
            title?.let { titleValue ->
                Text(
                    text = titleValue,
                    style = Theme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        })
    }

}

@Preview(showBackground = false)
@Composable
fun TopNavigationBarPreview() {
    RealEstateTheme {
        TopNavigationBar(title = "Home", onNavigateUp = { })
    }
}

@Preview(showBackground = false)
@Composable
fun TopNavigationBarSinglePreview() {
    RealEstateTheme {
        TopNavigationBar(title = "Home")
    }
}

@Preview(showBackground = false)
@Composable
fun TopNavigationBarTransparentPreview() {
    RealEstateTheme {
        TopNavigationBar(title = "Home", onNavigateUp = { }, isTransparent = true)
    }
}

@Preview(showBackground = false)
@Composable
fun TransparentTopTransparentNoTitlePreview() {
    RealEstateTheme {
        TopNavigationBar(onNavigateUp = { }, isTransparent = true)
    }
}