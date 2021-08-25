package com.dariusz.picsumapp.presentation.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.domain.model.Picture
import com.dariusz.picsumapp.presentation.components.navigation.Screens
import com.dariusz.picsumapp.utils.NavigationUtils.navigateToWithArguments

@ExperimentalCoilApi
@Composable
fun ImageListItem(
    input: Picture,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable(true, onClick = {
                navController.navigateToWithArguments(
                    Screens.AppScreens.DetailScreen.route,
                    input.id.toString()
                )
            })
            .testTag("list_element_${input.id}"),
        elevation = 10.dp
    ) {
        Column {
            ShowImage(
                url = input.downloadUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(maxHeight = 300.dp)
            )
            Text(text = "#${input.id}", modifier = Modifier.padding(5.dp))
        }
    }
}
