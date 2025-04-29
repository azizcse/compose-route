package com.tsl.common

sealed interface NavigationDestination {
    data object ToSplashScreen : NavigationDestination
}