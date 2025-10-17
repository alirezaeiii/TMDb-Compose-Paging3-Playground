package com.sample.tmdb.data.paging.tvshow

import com.sample.tmdb.data.paging.BaseTVSeriesPagingSourceTest
import com.sample.tmdb.data.response.NetworkTMDbWrapper
import com.sample.tmdb.data.response.TVShowResponse
import com.sample.tmdb.domain.model.TVShow
import com.sample.tmdb.domain.paging.BasePagingSource
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AiringTodayTVSeriesPagingSourceTest : BaseTVSeriesPagingSourceTest() {

    override suspend fun getApiCall(): NetworkTMDbWrapper<TVShowResponse> = api.airingTodayTVSeries(1)

    override fun getPagingDataSource(): BasePagingSource<TVShow> = AiringTodayTVSeriesPagingSource(context, api)
}
