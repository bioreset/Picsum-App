package com.dariusz.picsumapp.presentation.components.common

import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.presentation.components.navigation.MainNavHost
import com.dariusz.picsumapp.presentation.components.theme.PicSumAppTheme

@ExperimentalCoilApi
@Composable
fun PSApp() {
    PicSumAppTheme {
        MainNavHost()
    }
}
