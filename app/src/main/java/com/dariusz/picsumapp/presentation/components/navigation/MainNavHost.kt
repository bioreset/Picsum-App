package com.dariusz.picsumapp.presentation.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.di.UseCasesModule.provideShowDetailsOfImageAction
import com.dariusz.picsumapp.di.UseCasesModule.provideShowListOfImagesAction
import com.dariusz.picsumapp.presentation.screens.DetailScreen
import com.dariusz.picsumapp.presentation.screens.ListScreen
import com.dariusz.picsumapp.presentation.screens.ScreensViewModel
import com.dariusz.picsumapp.utils.ViewModelUtils.composeViewModel

@ExperimentalCoilApi
@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    val screensViewModel = composeViewModel {
        ScreensViewModel(
            provideShowListOfImagesAction(),
            provideShowDetailsOfImageAction()
        )
    }
    NavHost(
        navController = navController,
        startDestination = Screens.AppScreens.ListScreen.route
    ) {
        composable(route = Screens.AppScreens.ListScreen.route) {
            ListScreen(
                screensViewModel = screensViewModel,
                navController = navController
            )
        }
        composable(route = Screens.AppScreens.DetailScreen.route.plus("/{image_id}")) {
            DetailScreen(
                imageId = it.arguments?.getString("image_id")?.toInt() ?: 0,
                screensViewModel = screensViewModel
            )
        }
    }
}
