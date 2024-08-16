package com.sample.tmdb.feed

import androidx.activity.ComponentActivity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.sample.tmdb.domain.R as domainR
import com.sample.tmdb.domain.model.FeedWrapper
import com.sample.tmdb.domain.model.Movie
import com.sample.tmdb.domain.model.SortType
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyDouble
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString

class FeedScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule< ComponentActivity>()

    @Test
    fun feedCollectionListTest() {
        with(composeTestRule) {
            setContent {
                FeedCollectionList(
                    navController = rememberNavController(), collection = listOf(
                        FeedWrapper(
                            feeds = listOf(
                                Movie(
                                    anyInt(), anyString(), anyString(), anyString(),
                                    anyString(), "title", anyDouble(), anyInt()
                                )
                            ), domainR.string.text_trending, SortType.TRENDING
                        ), FeedWrapper(
                            feeds = listOf(
                                Movie(
                                    anyInt(), anyString(), anyString(), anyString(),
                                    anyString(), "name", anyDouble(), anyInt()
                                )
                            ), domainR.string.text_popular, SortType.MOST_POPULAR
                        )
                    )
                ) {}
            }
            onNodeWithText(activity.getString(domainR.string.text_trending)).assertIsDisplayed()
            onNodeWithText(activity.getString(domainR.string.text_popular)).assertIsDisplayed()
            onAllNodesWithText(activity.getString(R.string.more_item)).assertCountEquals(2)
            onNodeWithText("title").assertIsDisplayed()
            onNodeWithText("name").assertIsDisplayed()
        }
    }

    @Test
    fun pagerTMDbItemContainerTest() {
        with(composeTestRule) {
            setContent {
                PagerTMDbItemContainer(
                    item = FeedWrapper(
                        feeds = listOf(
                            Movie(
                                anyInt(), anyString(), anyString(), anyString(),
                                anyString(), "title", anyDouble(), anyInt()
                            )
                        ), domainR.string.text_popular, SortType.MOST_POPULAR
                    ), navController = rememberNavController()
                ) {}
            }
            onNodeWithText(activity.getString(domainR.string.text_popular)).assertIsDisplayed()
            onNodeWithText(activity.getString(R.string.more_item)).assertIsDisplayed()
            onNodeWithText("title").assertIsDisplayed()
        }

    }

    @Test
    fun trendingItemTest() {
        with(composeTestRule) {
            setContent {
                TrendingItem(stringResource(id = domainR.string.text_trending),
                    null,
                    "2024-12-29", {}
                )
            }
            onNodeWithText(activity.getString(domainR.string.text_trending)).assertIsDisplayed()
            onNodeWithText("2024-12-29").assertIsDisplayed()
        }
    }

    @Test
    fun headerTest() {
        with(composeTestRule) {
            setContent {
                Header(titleId = domainR.string.text_popular) {}
            }
            onNodeWithText(activity.getString(domainR.string.text_popular)).assertIsDisplayed()
            onNodeWithText("More").assertIsDisplayed()
        }
    }

    @Test
    fun feedsTest() {
        with(composeTestRule) {
            setContent {
                Feeds(
                    feeds = listOf(
                        Movie(
                            anyInt(), anyString(), anyString(), anyString(),
                            anyString(), "title", anyDouble(), anyInt()
                        )
                    ),
                    onFeedClick = {},
                    index = 0
                )
            }
            onNodeWithText("title").assertIsDisplayed()
        }
    }

    @Test
    fun tMDBItemTest() {
        with(composeTestRule) {
            setContent {
                TMDbItem(
                    tmdbItem = Movie(
                        anyInt(), anyString(), anyString(), anyString(),
                        anyString(), "title", anyDouble(), anyInt()
                    ),
                    onFeedClick = {},
                    index = 0
                )
            }
            onNodeWithText("title").assertIsDisplayed()
        }
    }
}