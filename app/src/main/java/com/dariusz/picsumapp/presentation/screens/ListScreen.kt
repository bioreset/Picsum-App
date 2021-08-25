package com.dariusz.picsumapp.presentation.screens

import androidx.compose.runtime.*
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.presentation.components.common.ListBuilder
import com.dariusz.picsumapp.utils.ManageResponseOnScreen.ManageResponseOnScreen
import com.dariusz.picsumapp.utils.ScreensUtils.DisplayScreen

@ExperimentalCoilApi
@Composable
fun ListScreen(
    screensViewModel: ScreensViewModel,
    navController: NavController
) {
    var page by remember { mutableStateOf((1..49).random()) }
    DisplayScreen(
        title = "PicSum App",
        viewModel = screensViewModel,
        input = { viewModel ->
            viewModel.listOfImages
        },
        content = { response ->
            ManageResponseOnScreen(response) { list ->
                ListBuilder(
                    input = list,
                    navController = navController
                )
            }
        },
        action = { viewModel ->
            viewModel.getListOfImages(page)
        },
        showButton = true,
        actionOnClick = { viewModel ->
            page = (1..49).random()
            viewModel.getListOfImages(page)
        }
    )
}

