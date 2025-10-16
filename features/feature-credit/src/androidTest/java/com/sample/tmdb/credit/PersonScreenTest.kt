package com.sample.tmdb.credit

import androidx.activity.ComponentActivity
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import com.sample.tmdb.common.R as commonR
import com.sample.tmdb.domain.model.Person
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt

class PersonScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun upTest() {
        with(composeTestRule) {
            setContent {
                Up {}
            }
            onNodeWithContentDescription(activity.getString(commonR.string.back)).assertIsDisplayed()
        }
    }

    @Test
    fun bodyTest() {
        val titleHeight = mutableStateOf(0.dp)
        with(composeTestRule) {
            setContent {
                Body(biography = "biography", titleHeight = titleHeight, scroll = rememberScrollState(0))
            }
            onNodeWithText(activity.getString(R.string.biography)).assertIsDisplayed()
            onNodeWithText("biography").assertIsDisplayed()
        }
    }

    @Test
    fun titleTest() {
        val titleHeight = mutableStateOf(0.dp)
        with(composeTestRule) {
            setContent {
                Title(
                    Person(
                        "birthDay",
                        "deathDay",
                        anyInt(),
                        "name",
                        "biography",
                        "PlaceOfBirth",
                        null,
                    ),
                    titleHeight,
                ) { 0 }
            }
            onNodeWithText("name").assertExists()
            onNodeWithText(activity.getString(R.string.born, "birthDay")).assertExists()
            onNodeWithText(activity.getString(R.string.death, "deathDay")).assertExists()
            onNodeWithText(activity.getString(R.string.from, "PlaceOfBirth")).assertExists()
        }
    }
}
