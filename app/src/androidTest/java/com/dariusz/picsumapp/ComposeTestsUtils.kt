package com.dariusz.picsumapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.presentation.components.theme.PicSumAppTheme

object ComposeTestsUtils {

    @ExperimentalCoilApi
    fun ComposeContentTestRule.launchApp(
        element: @Composable () -> Unit
    ) {
        setContent {
            PicSumAppTheme {
                element.invoke()
            }
        }
    }

}