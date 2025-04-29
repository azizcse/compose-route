package com.tsl.splash.navigation

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tsl.common.MainUiController
import com.tsl.common.NavigationDestination
import com.tsl.splash.navigation.ui.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
object SplashScreenRoute

fun NavController.navigateSplashScreen() = navigate(route = SplashScreenRoute)

fun NavGraphBuilder.splashScreenNavigation(
    navUiController: MutableState<MainUiController>,
    navigator: (destination: NavigationDestination) -> Unit,
) {
    composable<SplashScreenRoute> {
        SplashScreen(navUiController = navUiController, destination = { navigator(it) })
    }
}

