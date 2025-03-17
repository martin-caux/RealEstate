package dev.martincaux.core.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Light Color Scheme
val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = Blue99,
    primaryContainer = Blue90,
    onPrimaryContainer = Blue10,
    inversePrimary = Blue80,
    secondary = Gray40,
    onSecondary = Blue99,
    secondaryContainer = Gray90,
    onSecondaryContainer = Gray10,
    tertiary = Gray40,
    onTertiary = Blue99,
    tertiaryContainer = Gray90,
    onTertiaryContainer = Gray10,
    background = Blue99,
    onBackground = Gray10,
    surface = Blue99,
    onSurface = Gray10,
    surfaceVariant = Gray90,
    onSurfaceVariant = Gray30,
    surfaceTint = Blue40,
    inverseSurface = Gray20,
    inverseOnSurface = Gray95,
    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    outline = Gray50,
    outlineVariant = Gray80,
    scrim = Gray10
)

// Dark Color Scheme
val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    onPrimary = Blue20,
    primaryContainer = Blue30,
    onPrimaryContainer = Blue90,
    inversePrimary = Blue40,
    secondary = Gray80,
    onSecondary = Gray20,
    secondaryContainer = Gray30,
    onSecondaryContainer = Gray90,
    tertiary = Gray80,
    onTertiary = Gray20,
    tertiaryContainer = Gray30,
    onTertiaryContainer = Gray90,
    background = Gray10,
    onBackground = Gray90,
    surface = Gray10,
    onSurface = Gray90,
    surfaceVariant = Gray30,
    onSurfaceVariant = Gray80,
    surfaceTint = Blue80,
    inverseSurface = Gray90,
    inverseOnSurface = Gray20,
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    outline = Gray60,
    outlineVariant = Gray30,
    scrim = Gray10
)

val LocalSpacing = compositionLocalOf { Spacing() }
val spacing: Spacing
    @Composable @ReadOnlyComposable get() = LocalSpacing.current

@Composable
fun RealEstateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    CompositionLocalProvider(LocalSpacing provides Spacing()) {
        MaterialTheme(
            colorScheme = colorScheme, typography = Typography, content = content
        )
    }
}