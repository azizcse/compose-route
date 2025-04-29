package com.tsl.routemanage.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.tsl.routemanage.navigation.MainUiController
import com.tsl.routemanage.ui.theme.backgroundColor

@Composable
fun BottomNavigationBar(navController: NavController,
                        bottomBarState: MainUiController,) {
    AnimatedVisibility(
        visible = !bottomBarState.showBottomBar,
        enter =
            slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 400),
            ),
        exit =
            slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = 400),
            ),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(
                        WindowInsets.navigationBars
                            .asPaddingValues()
                            .calculateBottomPadding(),
                    ).background(backgroundColor),
        )
    }
}