package io.github.yamin8000.dooz.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val lightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
)


private val darkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
)

@Composable
fun DoozTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isPreviewing: Boolean = false,
    isDynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    val isDynamicColorReadyDevice =
        isDynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    val colors = when {
        isDynamicColorReadyDevice && isDarkTheme -> {
            dynamicDarkColorScheme(LocalContext.current).injectBrandColors(darkColors)
        }

        isDynamicColorReadyDevice && !isDarkTheme -> {
            dynamicLightColorScheme(LocalContext.current).injectBrandColors(lightColors)
        }

        isDarkTheme -> darkColors
        else -> lightColors
    }

    if (!isPreviewing) {
        val activity = LocalView.current.context as Activity
        SideEffect {
            activity.window.statusBarColor = colors.surface.toArgb()
            activity.window.navigationBarColor = colors.surface.toArgb()
            val wic =
                WindowCompat.getInsetsController(activity.window, activity.window.decorView)
            wic.isAppearanceLightStatusBars = !isDarkTheme
            wic.isAppearanceLightNavigationBars = !isDarkTheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}

fun ColorScheme.injectBrandColors(
    brandColorScheme: ColorScheme
): ColorScheme {
    return copy(
        secondary = brandColorScheme.secondary,
        onSecondary = brandColorScheme.onSecondary,
        secondaryContainer = brandColorScheme.secondaryContainer,
        onSecondaryContainer = brandColorScheme.onSecondaryContainer
    )
}

@Composable
fun PreviewTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    DoozTheme(
        isDarkTheme = isDarkTheme,
        isPreviewing = true,
        isDynamicColor = false,
        content = content
    )
}