package com.sample.tmdb.data.paging.tvshow

import com.sample.tmdb.data.paging.BaseTVSeriesPagingSourceTest
import com.sample.tmdb.data.response.NetworkTMDbWrapper
import com.sample.tmdb.data.response.TVShowResponse
import com.sample.tmdb.domain.model.TVShow
import com.sample.tmdb.domain.paging.BasePagingSource
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DiscoverTVSeriesPagingSourceTest : BaseTVSeriesPagingSourceTest() {

    override suspend fun getApiCall(): NetworkTMDbWrapper<TVShowResponse> = api.discoverTVSeries(1)

    override fun getPagingDataSource(): BasePagingSource<TVShow> = DiscoverTVSeriesPagingSource(context, api)
}
