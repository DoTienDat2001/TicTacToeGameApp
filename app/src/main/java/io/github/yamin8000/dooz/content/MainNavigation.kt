package io.github.yamin8000.dooz.content

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.yamin8000.dooz.content.game.GameContent
import io.github.yamin8000.dooz.content.settings.ThemeSetting
import io.github.yamin8000.dooz.content.settings.content.SettingsContent
import io.github.yamin8000.dooz.ui.navigation.Nav
import io.github.yamin8000.dooz.ui.theme.DoozTheme
import io.github.yamin8000.dooz.util.Constants
import io.github.yamin8000.dooz.util.DataStoreHelper

@Composable
fun MainNavigation(
    adContent: @Composable () -> Unit
) {
    val context = LocalContext.current
    var theme by remember { mutableStateOf(ThemeSetting.System) }
    val dataStore = DataStoreHelper(context.settings)

    LaunchedEffect(Unit) {
        theme = ThemeSetting.valueOf(
            dataStore.getString(Constants.theme) ?: ThemeSetting.System.name
        )
    }
    DoozTheme(
        isDarkTheme = isDarkTheme(theme, isSystemInDarkTheme()),
        isDynamicColor = theme == ThemeSetting.System
    ) {
        Column {
            val navController = rememberNavController()
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = Nav.Routes.game
            ) {
                composable(Nav.Routes.game) {
                    GameContent(
                        onNavigateToSettings = { navController.navigate(Nav.Routes.settings) },
                        onNavigateToAbout = { navController.navigate(Nav.Routes.about) }
                    )
                }

                composable(Nav.Routes.settings) {
                    SettingsContent(
                        onThemeChanged = { newTheme -> theme = newTheme },
                        onBackClick = { navController.popBackStack() }
                    )
                }

                composable(Nav.Routes.about) { AboutContent(onBackClick = { navController.popBackStack() }) }
            }
            adContent()
        }
    }
}

private fun isDarkTheme(
    themeSetting: ThemeSetting,
    isSystemInDarkTheme: Boolean
): Boolean {
    if (themeSetting == ThemeSetting.Light) return false
    if (themeSetting == ThemeSetting.System) return isSystemInDarkTheme
    if (themeSetting == ThemeSetting.Dark) return true
    return false
}