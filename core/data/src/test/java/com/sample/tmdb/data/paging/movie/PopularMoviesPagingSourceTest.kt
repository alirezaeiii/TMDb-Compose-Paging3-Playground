package com.sample.tmdb.data.paging.movie

import com.sample.tmdb.data.paging.BaseMoviePagingSourceTest
import com.sample.tmdb.data.response.MovieResponse
import com.sample.tmdb.data.response.NetworkTMDbWrapper
import com.sample.tmdb.domain.model.Movie
import com.sample.tmdb.domain.paging.BasePagingSource
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PopularMoviesPagingSourceTest : BaseMoviePagingSourceTest() {

    override suspend fun getApiCall(): NetworkTMDbWrapper<MovieResponse> = api.popularMovies(1)

    override fun getPagingDataSource(): BasePagingSource<Movie> = PopularMoviesPagingSource(context, api)
}
