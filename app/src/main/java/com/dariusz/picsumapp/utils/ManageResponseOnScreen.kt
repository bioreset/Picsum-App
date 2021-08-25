package com.dariusz.picsumapp.utils

import androidx.compose.runtime.Composable
import com.dariusz.picsumapp.domain.model.ResponseState
import com.dariusz.picsumapp.presentation.components.common.CenteredText
import com.dariusz.picsumapp.presentation.components.common.LoadingComponent
import retrofit2.HttpException

object ManageResponseOnScreen {

    @Composable
    fun <T> ManageResponseOnScreen(
        input: ResponseState<T>,
        content: @Composable (T) -> Unit,
    ) {
        when (input) {
            is ResponseState.Loading -> {
                LoadingComponent()
            }
            is ResponseState.Success -> {
                content.invoke(input.data)
            }
            is ResponseState.Error -> {
                CenteredText("Error: ${input.exception}")
            }
            is ResponseState.HttpError -> {
                CenteredText(
                    "Http Error (${if (input.exception is HttpException) input.exception.code() else 0}): " +
                            "${input.exception}"
                )
            }
            is ResponseState.Idle -> {
                // default option; do nothing
            }
        }
    }
}
