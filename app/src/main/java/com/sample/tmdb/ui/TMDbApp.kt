package com.sample.tmdb.ui

import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Tv
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sample.tmdb.R
import com.sample.tmdb.bookmark.BookmarkScreen
import com.sample.tmdb.common.MainDestinations
import com.sample.tmdb.common.model.Credit
import com.sample.tmdb.common.model.TMDbItem
import com.sample.tmdb.common.ui.Dimens.TMDb_0_dp
import com.sample.tmdb.common.ui.theme.AlphaNavigationBar
import com.sample.tmdb.credit.CreditScreen
import com.sample.tmdb.detail.MovieDetailScreen
import com.sample.tmdb.detail.TVShowDetailScreen
import com.sample.tmdb.domain.model.Cast
import com.sample.tmdb.domain.model.Crew
import com.sample.tmdb.domain.model.TMDbImage
import com.sample.tmdb.feed.MovieFeedScreen
import com.sample.tmdb.feed.TVShowFeedScreen
import com.sample.tmdb.gallery.ImagesScreen
import com.sample.tmdb.paging.main.AiringTodayTVShowScreen
import com.sample.tmdb.paging.main.DiscoverMovieScreen
import com.sample.tmdb.paging.main.DiscoverTVShowScreen
import com.sample.tmdb.paging.main.NowPlayingMovieScreen
import com.sample.tmdb.paging.main.OnTheAirTVShowScreen
import com.sample.tmdb.paging.main.PopularMovieScreen
import com.sample.tmdb.paging.main.PopularTVShowScreen
import com.sample.tmdb.paging.main.SimilarMovieScreen
import com.sample.tmdb.paging.main.SimilarTVShowScreen
import com.sample.tmdb.paging.main.TopRatedMovieScreen
import com.sample.tmdb.paging.main.TopRatedTVShowScreen
import com.sample.tmdb.paging.main.TrendingMovieScreen
import com.sample.tmdb.paging.main.TrendingTVShowScreen
import com.sample.tmdb.paging.main.UpcomingMovieScreen
import com.sample.tmdb.paging.search.SearchMoviesScreen
import com.sample.tmdb.paging.search.SearchTVSeriesScreen
import com.sample.tmdb.preson.PersonScreen
import com.sample.tmdb.setting.SettingsScreen

@Composable
fun TMDbApp() {
    val appState = rememberTMDbAppState()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                TMDbBottomBar(
                    tabs = appState.bottomBarTabs,
                    currentRoute = appState.currentRoute!!,
                    navigateToRoute = appState::navigateToBottomBarRoute,
                )
            }
        },
    ) { innerPaddingModifier ->
        val newPadding =
            PaddingValues(
                start = innerPaddingModifier.calculateStartPadding(LocalLayoutDirection.current),
                end = innerPaddingModifier.calculateEndPadding(LocalLayoutDirection.current),
                top = innerPaddingModifier.calculateTopPadding(),
                bottom = 0.dp,
            )
        NavHost(
            navController = appState.navController,
            startDestination = MainDestinations.HOME_ROUTE,
            modifier = Modifier.padding(newPadding),
        ) {
            navigationScreens(appState.navController, scaffoldState)
            detailScreens(appState.navController)
            moviePagingScreens(appState.navController)
            tvShowPagingScreens(appState.navController)
            searchScreens(appState.navController)
            creditScreens(appState.navController)
            personScreen(appState.navController)
            imagesScreen()
        }
    }
}

@Composable
private fun TMDbBottomBar(tabs: Array<HomeSections>, currentRoute: String, navigateToRoute: (String) -> Unit) {
    val currentSection = tabs.first { it.route == currentRoute }

    Box(
        Modifier.navigationBarsPadding(),
    ) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background.copy(alpha = AlphaNavigationBar),
            elevation = TMDb_0_dp,
        ) {
            tabs.forEach { section ->
                val selected = section == currentSection
                BottomNavigationItem(
                    label = {
                        Text(text = stringResource(id = section.title))
                    },
                    icon = {
                        Icon(
                            imageVector = if (selected) section.selectedIcon else section.unselectedIcon,
                            contentDescription = stringResource(id = section.title),
                        )
                    },
                    selected = selected,
                    unselectedContentColor = MaterialTheme.colors.onBackground.copy(alpha = ContentAlpha.disabled),
                    selectedContentColor = MaterialTheme.colors.onBackground,
                    onClick = { navigateToRoute(section.route) },
                )
            }
        }
    }
}

private fun NavGraphBuilder.navigationScreens(navController: NavController, scaffoldState: ScaffoldState) {
    navigation(
        route = MainDestinations.HOME_ROUTE,
        startDestination = HomeSections.MOVIE_SECTION.route,
    ) {
        composable(route = HomeSections.MOVIE_SECTION.route) {
            MovieFeedScreen(
                hiltViewModel(),
                { navController.navigate(MainDestinations.TMDB_SEARCH_MOVIE_ROUTE) },
                { navController.navigate("${MainDestinations.TMDB_MOVIE_DETAIL_ROUTE}/${it.id}") },
                { navController.navigate(it) },
                scaffoldState,
            )
        }
        composable(route = HomeSections.TV_SHOW_SECTION.route) {
            TVShowFeedScreen(
                hiltViewModel(),
                { navController.navigate(MainDestinations.TMDB_SEARCH_TV_SHOW_ROUTE) },
                { navController.navigate("${MainDestinations.TMDB_TV_SHOW_DETAIL_ROUTE}/${it.id}") },
                { navController.navigate(it) },
                scaffoldState,
            )
        }
        composable(route = HomeSections.BOOKMARK_SECTION.route) {
            BookmarkScreen(
                hiltViewModel(),
                hiltViewModel(),
                { navController.navigate("${MainDestinations.TMDB_MOVIE_DETAIL_ROUTE}/${it.id}") },
                { navController.navigate("${MainDestinations.TMDB_TV_SHOW_DETAIL_ROUTE}/${it.id}") },
            )
        }
        composable(route = HomeSections.SETTING_SECTION.route) {
            SettingsScreen()
        }
    }
}

private fun NavGraphBuilder.detailScreens(navController: NavController) {
    val navigateToPerson: (Credit) -> Unit =
        { person -> navController.navigate("${MainDestinations.TMDB_PERSON_ROUTE}/${person.id}") }
    val onImageSelected: (List<TMDbImage>, Int) -> Unit = { images, index ->
        navController.navigate(
            "${MainDestinations.TMDB_IMAGES_ROUTE}/${
                Uri.encode(
                    gson.toJson(images, object : TypeToken<List<TMDbImage>>() {}.type),
                )
            }/$index",
        )
    }
    val onSeeAllCastClicked: (List<Credit>) -> Unit = { cast ->
        navController.navigate(
            "${MainDestinations.TMDB_CAST_ROUTE}/${
                Uri.encode(
                    gson.toJson(cast, object : TypeToken<List<Cast>>() {}.type),
                )
            }",
        )
    }
    val onSeeAllCrewClicked: (List<Credit>) -> Unit = { crew ->
        navController.navigate(
            "${MainDestinations.TMDB_CREW_ROUTE}/${
                Uri.encode(
                    gson.toJson(crew, object : TypeToken<List<Crew>>() {}.type),
                )
            }",
        )
    }
    composable(
        route = "${MainDestinations.TMDB_MOVIE_DETAIL_ROUTE}/{${MainDestinations.TMDB_ID_KEY}}",
        arguments =
        listOf(
            navArgument(MainDestinations.TMDB_ID_KEY) { type = NavType.IntType },
        ),
    ) {
        MovieDetailScreen(
            hiltViewModel(),
            { navController.navigate("${MainDestinations.TMDB_MOVIE_DETAIL_ROUTE}/${it.id}") },
            { navController.navigate("${MainDestinations.TMDB_SIMILAR_MOVIES_ROUTE}/$it") },
            navigateToPerson,
            onImageSelected,
            onSeeAllCastClicked,
            onSeeAllCrewClicked,
            navController::navigateUp,
        )
    }
    composable(
        route = "${MainDestinations.TMDB_TV_SHOW_DETAIL_ROUTE}/{${MainDestinations.TMDB_ID_KEY}}",
        arguments =
        listOf(
            navArgument(MainDestinations.TMDB_ID_KEY) { type = NavType.IntType },
        ),
    ) {
        TVShowDetailScreen(
            hiltViewModel(),
            { navController.navigate("${MainDestinations.TMDB_TV_SHOW_DETAIL_ROUTE}/${it.id}") },
            { navController.navigate("${MainDestinations.TMDB_SIMILAR_TV_SHOW_ROUTE}/$it") },
            navigateToPerson,
            onImageSelected,
            onSeeAllCastClicked,
            onSeeAllCrewClicked,
            navController::navigateUp,
        )
    }
}

private fun NavGraphBuilder.moviePagingScreens(navController: NavController) {
    val onClicked: (TMDbItem) -> Unit =
        { navController.navigate("${MainDestinations.TMDB_MOVIE_DETAIL_ROUTE}/${it.id}") }
    val onSearchedClicked: () -> Unit = { navController.navigate(MainDestinations.TMDB_SEARCH_MOVIE_ROUTE) }
    composable(route = MainDestinations.TMDB_TRENDING_MOVIES_ROUTE) {
        TrendingMovieScreen(hiltViewModel(), onClicked, onSearchedClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_POPULAR_MOVIES_ROUTE) {
        PopularMovieScreen(hiltViewModel(), onClicked, onSearchedClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_NOW_PLAYING_MOVIES_ROUTE) {
        NowPlayingMovieScreen(hiltViewModel(), onClicked, onSearchedClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_UPCOMING_MOVIES_ROUTE) {
        UpcomingMovieScreen(hiltViewModel(), onClicked, onSearchedClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_TOP_RATED_MOVIES_ROUTE) {
        TopRatedMovieScreen(hiltViewModel(), onClicked, onSearchedClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_DISCOVER_MOVIES_ROUTE) {
        DiscoverMovieScreen(hiltViewModel(), onClicked, onSearchedClicked, navController::navigateUp)
    }
    composable(
        route = "${MainDestinations.TMDB_SIMILAR_MOVIES_ROUTE}/{${MainDestinations.TMDB_SIMILAR_ID}}",
        arguments =
        listOf(
            navArgument(MainDestinations.TMDB_SIMILAR_ID) { type = NavType.IntType },
        ),
    ) {
        SimilarMovieScreen(hiltViewModel(), onClicked, onSearchedClicked, navController::navigateUp)
    }
}

private fun NavGraphBuilder.tvShowPagingScreens(navController: NavController) {
    val onClicked: (TMDbItem) -> Unit =
        { navController.navigate("${MainDestinations.TMDB_TV_SHOW_DETAIL_ROUTE}/${it.id}") }
    val onSearchClicked: () -> Unit = { navController.navigate(MainDestinations.TMDB_SEARCH_TV_SHOW_ROUTE) }
    composable(route = MainDestinations.TMDB_TRENDING_TV_SHOW_ROUTE) {
        TrendingTVShowScreen(hiltViewModel(), onClicked, onSearchClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_POPULAR_TV_SHOW_ROUTE) {
        PopularTVShowScreen(hiltViewModel(), onClicked, onSearchClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_AIRING_TODAY_TV_SHOW_ROUTE) {
        AiringTodayTVShowScreen(hiltViewModel(), onClicked, onSearchClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_ON_THE_AIR_TV_SHOW_ROUTE) {
        OnTheAirTVShowScreen(hiltViewModel(), onClicked, onSearchClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_TOP_RATED_TV_SHOW_ROUTE) {
        TopRatedTVShowScreen(hiltViewModel(), onClicked, onSearchClicked, navController::navigateUp)
    }
    composable(route = MainDestinations.TMDB_DISCOVER_TV_SHOW_ROUTE) {
        DiscoverTVShowScreen(hiltViewModel(), onClicked, onSearchClicked, navController::navigateUp)
    }
    composable(
        route = "${MainDestinations.TMDB_SIMILAR_TV_SHOW_ROUTE}/{${MainDestinations.TMDB_SIMILAR_ID}}",
        arguments =
        listOf(
            navArgument(MainDestinations.TMDB_SIMILAR_ID) { type = NavType.IntType },
        ),
    ) {
        SimilarTVShowScreen(hiltViewModel(), onClicked, onSearchClicked, navController::navigateUp)
    }
}

private fun NavGraphBuilder.searchScreens(navController: NavController) {
    composable(route = MainDestinations.TMDB_SEARCH_MOVIE_ROUTE) {
        SearchMoviesScreen(
            hiltViewModel(),
            { navController.navigate("${MainDestinations.TMDB_MOVIE_DETAIL_ROUTE}/${it.id}") },
            navController::navigateUp,
        )
    }
    composable(route = MainDestinations.TMDB_SEARCH_TV_SHOW_ROUTE) {
        SearchTVSeriesScreen(
            hiltViewModel(),
            { navController.navigate("${MainDestinations.TMDB_TV_SHOW_DETAIL_ROUTE}/${it.id}") },
            navController::navigateUp,
        )
    }
}

private fun NavGraphBuilder.creditScreens(navController: NavController) {
    val navigate: (person: Credit) -> Unit =
        { person -> navController.navigate("${MainDestinations.TMDB_PERSON_ROUTE}/${person.id}") }
    composable(
        route = "${MainDestinations.TMDB_CAST_ROUTE}/{${MainDestinations.TMDB_CREDIT_KEY}}",
        arguments =
        listOf(
            navArgument(MainDestinations.TMDB_CREDIT_KEY) { type = NavType.StringType },
        ),
    ) { from ->
        CreditScreen(
            R.string.cast,
            navController::navigateUp,
            navigate,
            gson.fromJson<List<Cast>>(
                from.arguments?.getString(MainDestinations.TMDB_CREDIT_KEY),
                object : TypeToken<List<Cast>>() {}.type,
            ),
        )
    }
    composable(
        route = "${MainDestinations.TMDB_CREW_ROUTE}/{${MainDestinations.TMDB_CREDIT_KEY}}",
        arguments =
        listOf(
            navArgument(MainDestinations.TMDB_CREDIT_KEY) { type = NavType.StringType },
        ),
    ) { from ->
        CreditScreen(
            R.string.crew,
            navController::navigateUp,
            navigate,
            gson.fromJson<List<Crew>>(
                from.arguments?.getString(MainDestinations.TMDB_CREDIT_KEY),
                object : TypeToken<List<Crew>>() {}.type,
            ),
        )
    }
}

private fun NavGraphBuilder.personScreen(navController: NavController) {
    composable(
        route = "${MainDestinations.TMDB_PERSON_ROUTE}/{${MainDestinations.TMDB_PERSON_KEY}}",
        arguments =
        listOf(
            navArgument(MainDestinations.TMDB_PERSON_KEY) { type = NavType.StringType },
        ),
    ) {
        PersonScreen(hiltViewModel(), navController::navigateUp)
    }
}

private fun NavGraphBuilder.imagesScreen() {
    composable(
        route = "${MainDestinations.TMDB_IMAGES_ROUTE}/{${MainDestinations.TMDB_IMAGES_KEY}}" +
            "/{${MainDestinations.TMDB_IMAGE_PAGE}}",
        arguments =
        listOf(
            navArgument(MainDestinations.TMDB_IMAGES_KEY) { type = NavType.StringType },
            navArgument(MainDestinations.TMDB_IMAGE_PAGE) { type = NavType.IntType },
        ),
    ) { from ->
        ImagesScreen(
            images =
            gson.fromJson(
                from.arguments?.getString(MainDestinations.TMDB_IMAGES_KEY),
                object : TypeToken<List<TMDbImage>>() {}.type,
            ),
            initialPage = from.arguments?.getInt(MainDestinations.TMDB_IMAGE_PAGE)!!,
        )
    }
}

enum class HomeSections(
    val route: String,
    @StringRes val title: Int,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
) {
    MOVIE_SECTION("Movie", R.string.movie, Icons.Outlined.Movie, Icons.Filled.Movie),
    TV_SHOW_SECTION("TVShow", R.string.tv_show, Icons.Outlined.Tv, Icons.Filled.Tv),
    BOOKMARK_SECTION("Bookmark", R.string.favorite, Icons.Outlined.Favorite, Icons.Filled.Favorite),
    SETTING_SECTION("Setting", R.string.setting, Icons.Outlined.Settings, Icons.Filled.Settings),
}

private val gson = Gson()
