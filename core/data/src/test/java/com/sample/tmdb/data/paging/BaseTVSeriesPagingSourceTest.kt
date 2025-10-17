package com.sample.tmdb.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.Page
import com.sample.tmdb.data.network.TVShowService
import com.sample.tmdb.data.response.NetworkTMDbWrapper
import com.sample.tmdb.data.response.TVShowResponse
import com.sample.tmdb.data.response.asTVShowDomainModel
import com.sample.tmdb.domain.model.TVShow
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

abstract class BaseTVSeriesPagingSourceTest : BasePagingSourceTest<TVShow, TVShowResponse>() {

    @Mock
    protected lateinit var api: TVShowService

    private val tvShow1 = TVShowResponse(
        1,
        "overview1",
        null,
        null,
        null,
        "name1",
        1.1,
        1,
    )
    private val tvShow2 = TVShowResponse(
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
        `when`(getApiCall()).thenReturn(NetworkTMDbWrapper(listOf(tvShow1, tvShow2)))
    }

    @Test
    fun pageKeyedShowPagingSource() = runTest {
        mockApiResponse()
        assertEquals(
            expected = Page(
                data = listOf(tvShow1, tvShow2).asTVShowDomainModel(),
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
