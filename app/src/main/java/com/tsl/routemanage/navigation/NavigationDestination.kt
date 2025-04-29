package com.tsl.routemanage.navigation

sealed interface NavigationDestination {
    data object ToSplashScreen : NavigationDestination
    data object ToProfileScreen : NavigationDestination
}