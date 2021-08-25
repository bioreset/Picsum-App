package com.dariusz.picsumapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.ComposeTestsUtils.launchApp
import com.dariusz.picsumapp.presentation.components.navigation.MainNavHost
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PicsumAppComposeTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @ExperimentalCoilApi
    @Before
    fun setUp() {
        composeTestRule.launchApp {
            MainNavHost()
        }
    }

    @Test
    fun determineIfHeaderIsDisplayed() {
        composeTestRule.onNodeWithText("PicSum App").assertIsDisplayed()
    }

    @Test
    fun determineIfReloadButtonWorks() {
        composeTestRule.onNodeWithTag("reload_button").assertIsEnabled().assertHasClickAction()
    }

}