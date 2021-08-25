package com.dariusz.picsumapp.presentation.components.navigation

sealed class Screens(val route: String, val title: String) {

    sealed class AppScreens(
        route: String,
        title: String,
    ) : Screens(
        route,
        title
    ) {
        object ListScreen : AppScreens("list", "Images")
        object DetailScreen : AppScreens("detail", "Image Details")
    }

}
