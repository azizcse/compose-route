package com.tsl.routemanage.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import com.tsl.routemanage.navigation.MainUiController
import com.tsl.routemanage.navigation.NavigationDestination
import kotlinx.coroutines.delay

@Composable
internal fun SplashScreen(
    navUiController: MutableState<MainUiController>,
    modifier: Modifier = Modifier,
    destination: (NavigationDestination) -> Unit,
) {
    LaunchedEffect(true) {
        delay(5000)
        navUiController.value = navUiController.value
        destination(NavigationDestination.ToProfileScreen)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Splash Screen"
        )
    }
}