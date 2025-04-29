package com.tsl.routemanage.feature.profile

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tsl.routemanage.navigation.MainUiController
import com.tsl.routemanage.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
object ProfileScreenRoute

fun NavController.navigateProfileScreen() = navigate(route = ProfileScreenRoute)

fun NavGraphBuilder.profileScreenNavigation(
    navUiController: MutableState<MainUiController>,
    navigator: (destination: NavigationDestination) -> Unit,
) {
    composable<ProfileScreenRoute> {
        ProfileScreen(navUiController = navUiController, destination = { navigator(it) })
    }
}
