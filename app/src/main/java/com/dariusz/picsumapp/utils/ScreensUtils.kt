package com.dariusz.picsumapp.utils

import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.ViewModel
import com.dariusz.picsumapp.presentation.components.common.TopBar
import com.dariusz.picsumapp.utils.ViewModelUtils.composeViewModel
import kotlinx.coroutines.flow.StateFlow

object ScreensUtils {

    /*
     * inline fun [name_of_function] = to allow multiple lambdas as parameters + reified (reflection) parameter
     * crossinline [name_of_parameter] = to allow lambda as parameter
     * noinline [actionOnClick] = to allow optional lambda (depends on showButton boolean state parameter)
     */

    @Composable
    inline fun <reified VM : ViewModel, T> DisplayScreen(
        title: String,
        viewModel: VM,
        input: (VM) -> StateFlow<T>,
        crossinline content: @Composable (T) -> Unit,
        crossinline action: (VM) -> Any?,
        showButton: Boolean = false,
        noinline actionOnClick: ((VM) -> Any)? = null,
    ) {

        val initVM = composeViewModel {
            viewModel
        }

        val currentVM by remember { mutableStateOf(initVM) }

        action.invoke(currentVM)

        val rememberData by remember(currentVM) {
            input.invoke(currentVM)
        }.collectAsState()

        if (showButton) {
            Scaffold(
                topBar = {
                    TopBar(title)
                },
                content = {
                    content.invoke(rememberData)
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { actionOnClick?.invoke(currentVM) },
                        modifier = Modifier.testTag("reload_button")
                    ) {
                        Icon(imageVector = Icons.Filled.Refresh, contentDescription = "")
                    }
                },
                floatingActionButtonPosition = FabPosition.End
            )
        } else {
            Scaffold(
                topBar = {
                    TopBar(title)
                },
                content = {
                    content.invoke(rememberData)
                }
            )
        }
    }
}
