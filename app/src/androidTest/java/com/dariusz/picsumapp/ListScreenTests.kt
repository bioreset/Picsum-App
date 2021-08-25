package com.dariusz.picsumapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.ComposeTestsUtils.launchApp
import com.dariusz.picsumapp.TestDataSource.testImagesList
import com.dariusz.picsumapp.presentation.components.common.ListBuilder
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListScreenTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @ExperimentalCoilApi
    @Before
    fun setUpList() {
        composeTestRule.launchApp {
            ListBuilder(testImagesList)
        }
    }

    @Test
    fun areItemWithIdOneLoaded() {
        composeTestRule.onNodeWithTag("list_element_1").assertIsDisplayed()
    }


}