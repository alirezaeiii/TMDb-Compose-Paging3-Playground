package com.sample.tmdb.data.paging.movie

import com.sample.tmdb.data.paging.BaseMoviePagingSourceTest
import com.sample.tmdb.data.response.MovieResponse
import com.sample.tmdb.data.response.NetworkTMDbWrapper
import com.sample.tmdb.domain.model.Movie
import com.sample.tmdb.domain.paging.BasePagingSource
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SimilarMoviesPagingSourceTest : BaseMoviePagingSourceTest() {

    override suspend fun getApiCall(): NetworkTMDbWrapper<MovieResponse> = api.fetchSimilarMovies(1, 1)

    override fun initPagingSource(): BasePagingSource<Movie> = SimilarMoviesPagingSource(context, api, 1)
}
