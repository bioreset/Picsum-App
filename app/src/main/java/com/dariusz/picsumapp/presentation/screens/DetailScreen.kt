package com.dariusz.picsumapp.presentation.screens

import androidx.compose.runtime.*
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.presentation.components.common.DetailScreenBuilder
import com.dariusz.picsumapp.utils.ManageResponseOnScreen.ManageResponseOnScreen
import com.dariusz.picsumapp.utils.ScreensUtils.DisplayScreen

@ExperimentalCoilApi
@Composable
fun DetailScreen(
    imageId: Int,
    screensViewModel: ScreensViewModel
) {
    val idOfImage by remember {
        mutableStateOf(imageId)
    }

    LaunchedEffect(idOfImage) {
        screensViewModel.getDetailsForImage(idOfImage)
    }

    DisplayScreen(
        title = "Image Details",
        viewModel = screensViewModel,
        input = { viewModel ->
            viewModel.imageDetails
        },
        content = { response ->
            ManageResponseOnScreen(response) { pictureDetail ->
                DetailScreenBuilder(pictureDetail)
            }
        },
        action = { viewModel ->
            LaunchedEffect(idOfImage) {
                viewModel.getDetailsForImage(idOfImage)
            }
        }
    )
}
