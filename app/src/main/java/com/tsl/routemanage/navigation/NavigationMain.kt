package com.tsl.routemanage.navigation

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tsl.routemanage.feature.SplashScreenRoute
import com.tsl.routemanage.feature.profile.profileScreenNavigation
import com.tsl.routemanage.feature.splashScreenNavigation

@Composable
fun NavigationMain(
    navController: NavHostController,
    paddingValues: PaddingValues,
    navUiController: MutableState<MainUiController>,
) {
    NavHost(
        navController,
        startDestination = SplashScreenRoute,
        modifier =
            Modifier
                .padding(
                    // top = paddingValues.calculateTopPadding(),
                    start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                    end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                    bottom = paddingValues.calculateBottomPadding(),
                )
                .fillMaxWidth(),
    ) {
        splashScreenNavigation(navUiController) {
            Log.e("ui-navigation", "Splash screen show")
            navUiController.value = navUiController.value.copy(
                showNavigationTopBar = true
            )
            navController.gotoDestination(it)
        }

        profileScreenNavigation(navUiController) {
            navUiController.value = navUiController.value.copy(
                showNavigationTopBar = true
            )
            navController.gotoDestination(it)
        }

    }
}