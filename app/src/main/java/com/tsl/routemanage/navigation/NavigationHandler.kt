package com.tsl.routemanage.navigation

import androidx.navigation.NavController
import com.tsl.routemanage.feature.navigateSplashScreen
import com.tsl.routemanage.feature.profile.navigateProfileScreen

fun NavController.gotoDestination(destination: NavigationDestination) {
    when (destination) {
        is NavigationDestination.ToSplashScreen -> {
            navigateSplashScreen()
        }

        NavigationDestination.ToProfileScreen -> {
            popBackStack()
            navigateProfileScreen()
        }
    }
}