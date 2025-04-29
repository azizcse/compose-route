package com.tsl.splash.navigation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.material3.Text
import com.tsl.common.MainUiController
import com.tsl.common.NavigationDestination

@Composable
internal fun SplashScreen(
    navUiController: MutableState<MainUiController>,
    modifier: Modifier = Modifier,
    destination: (NavigationDestination) -> Unit,){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Splash Screen"
        )
    }
}