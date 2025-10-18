package com.sample.tmdb.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import com.sample.tmdb.data.network.MovieService
import com.sample.tmdb.data.response.MovieResponse
import com.sample.tmdb.data.response.NetworkTMDbWrapper
import com.sample.tmdb.data.response.asMovieDomainModel
import com.sample.tmdb.domain.model.Movie
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

abstract class BaseMoviePagingSourceTest : BasePagingSourceTest<Movie, MovieResponse>() {

    @Mock
    protected lateinit var api: MovieService

    private val movie1 = MovieResponse(
        1,
        "overview1",
        null,
        null,
        null,
        "name1",
        1.1,
        1,
    )
    private val movie2 = MovieResponse(
        2,
        "overview2",
        null,
        null,
        null,
        "name2",
        1.1,
        1,
    )

    override fun mockApiResponse() = runTest {
        `when`(getApiCall()).thenReturn(NetworkTMDbWrapper(listOf(movie1, movie2)))
    }

    @Test
    fun pageKeyedShowPagingSource() = runTest {
        assertEquals(
            expected = Page(
                data = listOf(movie1, movie2).asMovieDomainModel(),
                prevKey = null,
                nextKey = 2,
            ),
            actual = pagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false,
                ),
            ),
        )
    }
}
