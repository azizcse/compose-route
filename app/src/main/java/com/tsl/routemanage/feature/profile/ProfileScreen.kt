package com.tsl.routemanage.feature.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tsl.routemanage.navigation.MainUiController
import com.tsl.routemanage.navigation.NavigationDestination
import kotlinx.coroutines.delay

@Composable
internal fun ProfileScreen(
    navUiController: MutableState<MainUiController>,
    modifier: Modifier = Modifier,
    destination: (NavigationDestination) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(
                text = "Profile Screen"
            )
            Button(onClick = {
                val isShow = navUiController.value.showNavigationTopBar
                navUiController.value = navUiController.value.copy(showNavigationTopBar = !isShow)
            }) {
                Text("Click me")
            }
        }
    }
}

