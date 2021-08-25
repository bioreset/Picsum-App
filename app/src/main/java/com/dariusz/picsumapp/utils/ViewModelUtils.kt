package com.dariusz.picsumapp.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

object ViewModelUtils {

    //Creating an instance of ViewModel in composable

    @Suppress("UNCHECKED_CAST")
    @Composable
    inline fun <reified VM : ViewModel> composeViewModel(crossinline viewModel: () -> VM): VM =
        viewModel(
            factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return viewModel.invoke() as T
                }
            }
        )

    //Launch inside ViewModelScope with IO Dispatcher for network fetching and state saving

    private val ViewModel.ioTask
        get() = viewModelScope + Dispatchers.IO

    fun ViewModel.launchVMTask(
        action: suspend () -> Unit,
    ) = ioTask.launch {
        action.invoke()
    }

}
