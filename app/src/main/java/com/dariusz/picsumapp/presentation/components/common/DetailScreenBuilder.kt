package com.dariusz.picsumapp.presentation.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.domain.model.PictureDetail
import com.dariusz.picsumapp.utils.NavigationUtils.openInBrowser

@ExperimentalCoilApi
@Composable
fun DetailScreenBuilder(
    input: PictureDetail
) {
    val currentContext = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShowImage(
            url = input.downloadUrl,
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(maxHeight = 350.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        LeftRightText(left = "Photo ID: ", right = input.id.toString())
        LeftRightText(left = "Author: ", right = input.author)
        LeftRightText(left = "Width: ", right = input.width.toString())
        LeftRightText(left = "Height: ", right = input.height.toString())
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Download url: \n ${input.downloadUrl} ",
            modifier = Modifier
                .clickable(true, onClick = {
                    currentContext.openInBrowser(
                        input.downloadUrl
                    )
                })
                .padding(5.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Browse to image url",
            modifier = Modifier
                .clickable(true, onClick = {
                    currentContext.openInBrowser(
                        input.url
                    )
                })
                .padding(5.dp),
            textAlign = TextAlign.Center
        )

    }

}
