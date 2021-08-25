package com.dariusz.picsumapp.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.navigation.NavController

object NavigationUtils {

    fun NavController.navigateToWithArguments(
        screenRoute: String,
        argument: String? = null,
    ) = navigate(screenRoute.plus("/$argument")) {
        graph.startDestinationRoute?.let { route ->
            popUpTo(route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }

    fun Context.openInBrowser(url: String) {
        val defaultBrowser =
            Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
        defaultBrowser.data = Uri.parse(url)
        return startActivity(defaultBrowser)
    }
}
