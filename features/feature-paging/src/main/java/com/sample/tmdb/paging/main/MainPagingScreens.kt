package com.sample.tmdb.paging.main

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sample.tmdb.common.model.TMDbItem
import com.sample.tmdb.common.ui.component.DestinationBar
import com.sample.tmdb.paging.BasePagingViewModel
import com.sample.tmdb.paging.PagingScreen
import com.sample.tmdb.paging.R
import com.sample.tmdb.paging.main.movie.DiscoverMoviesViewModel
import com.sample.tmdb.paging.main.movie.NowPlayingMoviesViewModel
import com.sample.tmdb.paging.main.movie.PopularMoviesViewModel
import com.sample.tmdb.paging.main.movie.SimilarMoviesViewModel
import com.sample.tmdb.paging.main.movie.TopRatedMoviesViewModel
import com.sample.tmdb.paging.main.movie.TrendingMoviesViewModel
import com.sample.tmdb.paging.main.movie.UpcomingMoviesViewModel
import com.sample.tmdb.paging.main.tvshow.AiringTodayTvSeriesViewModel
import com.sample.tmdb.paging.main.tvshow.DiscoverTvSeriesViewModel
import com.sample.tmdb.paging.main.tvshow.OnTheAirTvSeriesViewModel
import com.sample.tmdb.paging.main.tvshow.PopularTvSeriesViewModel
import com.sample.tmdb.paging.main.tvshow.SimilarTvSeriesViewModel
import com.sample.tmdb.paging.main.tvshow.TopRatedTvSeriesViewModel
import com.sample.tmdb.paging.main.tvshow.TrendingTvSeriesViewModel

@Composable
fun TrendingMovieScreen(
    viewModel: TrendingMoviesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.trending,
            stringResource(com.sample.tmdb.common.R.string.movies),
        ),
    )
}

@Composable
fun PopularMovieScreen(
    viewModel: PopularMoviesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        stringResource(
            R.string.popular,
            stringResource(com.sample.tmdb.common.R.string.movies),
        ),
    )
}

@Composable
fun NowPlayingMovieScreen(
    viewModel: NowPlayingMoviesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.now_playing,
            stringResource(com.sample.tmdb.common.R.string.movies),
        ),
    )
}

@Composable
fun UpcomingMovieScreen(
    viewModel: UpcomingMoviesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.upcoming,
            stringResource(com.sample.tmdb.common.R.string.movies),
        ),
    )
}

@Composable
fun TopRatedMovieScreen(
    viewModel: TopRatedMoviesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.highest_rate,
            stringResource(com.sample.tmdb.common.R.string.movies),
        ),
    )
}

@Composable
fun DiscoverMovieScreen(
    viewModel: DiscoverMoviesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.discover,
            stringResource(com.sample.tmdb.common.R.string.movies),
        ),
    )
}

@Composable
fun SimilarMovieScreen(
    viewModel: SimilarMoviesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.similar_items,
            stringResource(com.sample.tmdb.common.R.string.movies),
        ),
    )
}

@Composable
fun TrendingTVShowScreen(
    viewModel: TrendingTvSeriesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.trending,
            stringResource(com.sample.tmdb.common.R.string.tv_series),
        ),
    )
}

@Composable
fun PopularTVShowScreen(
    viewModel: PopularTvSeriesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.popular,
            stringResource(com.sample.tmdb.common.R.string.tv_series),
        ),
    )
}

@Composable
fun AiringTodayTVShowScreen(
    viewModel: AiringTodayTvSeriesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.airing_today,
            stringResource(com.sample.tmdb.common.R.string.tv_series),
        ),
    )
}

@Composable
fun OnTheAirTVShowScreen(
    viewModel: OnTheAirTvSeriesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.on_the_air,
            stringResource(com.sample.tmdb.common.R.string.tv_series),
        ),
    )
}

@Composable
fun TopRatedTVShowScreen(
    viewModel: TopRatedTvSeriesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.highest_rate,
            stringResource(com.sample.tmdb.common.R.string.tv_series),
        ),
    )
}

@Composable
fun DiscoverTVShowScreen(
    viewModel: DiscoverTvSeriesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.discover,
            stringResource(com.sample.tmdb.common.R.string.tv_series),
        ),
    )
}

@Composable
fun SimilarTVShowScreen(
    viewModel: SimilarTvSeriesViewModel,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
) {
    PagingScreen(
        viewModel = viewModel,
        onClick = onClick,
        onSearchClicked = onSearchClicked,
        navigateUp = navigateUp,
        title =
        stringResource(
            R.string.similar_items,
            stringResource(com.sample.tmdb.common.R.string.tv_series),
        ),
    )
}

@Composable
private fun <T : TMDbItem> PagingScreen(
    viewModel: BasePagingViewModel<T>,
    onClick: (TMDbItem) -> Unit,
    onSearchClicked: () -> Unit,
    navigateUp: () -> Unit,
    title: String,
) {
    Box {
        PagingScreen(viewModel, onClick)
        DestinationBar(
            title = title,
            upPress = navigateUp,
            onSearchClicked = onSearchClicked,
        )
    }
}
