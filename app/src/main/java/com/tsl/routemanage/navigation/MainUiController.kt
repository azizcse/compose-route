package com.tsl.routemanage.navigation

data class MainUiController(
    var showBottomBar: Boolean = false,
    var showNavigationTopBar: Boolean = false,
)

/*fun MainUiController.hideBottomAndTop(): MainUiController {
    this.showBottomBar = false
    return this
}

fun MainUiController.showTopBar(): MainUiController {
    this.showNavigationTopBar = true
    return this
}

fun MainUiController.hideTopBar(): MainUiController {
    this.showNavigationTopBar = false
    return this
}*/