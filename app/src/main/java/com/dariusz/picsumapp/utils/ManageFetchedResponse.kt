package com.dariusz.picsumapp.utils

import com.dariusz.picsumapp.domain.model.ResponseState
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.HttpException

object ManageFetchedResponse {

    fun <T> manageResult(
        mutableInput: MutableStateFlow<ResponseState<T>>,
        dataFromAction: T,
    ) = mutableInput.getResultOfResponse(dataFromAction)

    private fun <T> MutableStateFlow<ResponseState<T>>.getResultOfResponse(
        data: T?,
    ) {
        value = ResponseState.Loading
        value = try {
            ResponseState.Success(data!!)
        } catch (exception: Exception) {
            if (exception is HttpException) {
                ResponseState.HttpError(exception)
            } else {
                ResponseState.Error(exception)
            }
        }
    }

}