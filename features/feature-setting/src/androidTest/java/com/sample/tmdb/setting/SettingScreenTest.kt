package com.sample.tmdb.setting

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class SettingScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun titleText() {
        with(composeTestRule) {
            setContent {
                TitleText(title = "title")
            }
            onNodeWithText("title").assertIsDisplayed()
        }
    }
}
