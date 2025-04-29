package com.tsl.routemanage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tsl.routemanage.component.BottomNavigationBar
import com.tsl.routemanage.navigation.MainApp
import com.tsl.routemanage.navigation.MainUiController
import com.tsl.routemanage.ui.theme.RouteManageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        this.setContent {
            val navController = rememberNavController()
            RouteManageTheme {
                MainScreen(navController)
            }
        }
    }
}

@Composable
private fun MainScreen(navController: NavHostController) {
    val mainUiController =
        remember {
            mutableStateOf(MainUiController())
        }
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycle = lifecycleOwner.lifecycle
    Scaffold(
        topBar = {
            TopBar(mainUiController)
        },
        content = { paddingValues ->
            CompositionLocalProvider(LocalPaddingValue provides paddingValues) {
                MainApp(navController, paddingValues, mainUiController)
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navController,
                mainUiController.value,
            )
        },
    )
}

@Composable
fun TopBar(mainUiController: MutableState<MainUiController>) {
    AnimatedVisibility(
        visible = mainUiController.value.showNavigationTopBar,
        enter =
            slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 150),
            ),
        exit =
            slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = 150),
            ),
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.08f)

        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(
                        top =
                            WindowInsets.statusBars
                                .asPaddingValues()
                                .calculateTopPadding(),
                        bottom = 10.dp,
                        start = 16.dp,
                        end = 16.dp,
                    )
                    .verticalScroll(rememberScrollState()),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Text(
                        text = "Bottom",

                        modifier = Modifier.weight(0.85f),
                    )

                    // This is where your composable is invoked

                    Text(
                        text = "Accept",

                        )
                }
            }
        }
    }
}

val LocalPaddingValue = compositionLocalOf { PaddingValues() }