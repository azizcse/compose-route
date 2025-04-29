package com.tsl.routemanage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController

@Composable
fun MainApp(
    navController: NavHostController,
    paddingValues: PaddingValues,
    navUiController: MutableState<MainUiController>,
) {
    NavigationMain(navController = navController, paddingValues = paddingValues, navUiController)
}
