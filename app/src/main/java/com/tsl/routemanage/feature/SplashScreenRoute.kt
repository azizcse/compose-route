package com.tsl.routemanage.feature

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tsl.routemanage.navigation.MainUiController
import com.tsl.routemanage.navigation.NavigationDestination
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

