package com.dariusz.picsumapp.presentation.components.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.domain.model.Picture

@ExperimentalCoilApi
@Composable
fun ListBuilder(
    input: List<Picture>,
    navController: NavController? = null
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        items(input) { listItem ->
            if (navController != null) {
                ImageListItem(listItem, navController)
            }
        }
    }
}
