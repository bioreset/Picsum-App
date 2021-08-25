package com.dariusz.picsumapp.presentation.components.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TopBar(text: String) {
    TopAppBar(
        title = { Text(text) },
        backgroundColor = Color.Black,
        contentColor = Color.White
    )
}
