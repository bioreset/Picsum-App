package com.dariusz.picsumapp

import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import coil.annotation.ExperimentalCoilApi
import com.dariusz.picsumapp.ComposeTestsUtils.launchApp
import com.dariusz.picsumapp.TestDataSource.getItemForId
import com.dariusz.picsumapp.TestDataSource.testImagesWithInfo
import com.dariusz.picsumapp.presentation.components.common.DetailScreenBuilder
import org.junit.Rule
import org.junit.Test

@ExperimentalCoilApi
class DetailScreenTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun isFirstItemDisplayed() {
        initDetailScreen(1)
        composeTestRule.onNodeWithTag("image_id_1")
    }

    @Test
    fun isSecondItemDisplayed() {
        initDetailScreen(2)
        composeTestRule.onNodeWithTag("image_id_2")
    }

    @Test
    fun isThirdItemDisplayed() {
        initDetailScreen(3)
        composeTestRule.onNodeWithTag("image_id_3")
    }

    @Test
    fun isFourthItemDisplayed() {
        initDetailScreen(4)
        composeTestRule.onNodeWithTag("image_id_4")
    }

    @Test
    fun isFifthItemDisplayed() {
        initDetailScreen(5)
        composeTestRule.onNodeWithTag("image_id_5")
    }

    @Test
    fun isSixthItemDisplayed() {
        initDetailScreen(6)
        composeTestRule.onNodeWithTag("image_id_6")
    }

    private fun initDetailScreen(imageId: Int) {
        composeTestRule.launchApp {
            testImagesWithInfo.getItemForId(imageId).forEach {
                DetailScreenBuilder(it)
                Text(
                    it.toString(),
                    modifier = Modifier.testTag("image_id_${it.id}")
                )
            }
        }
    }
}