package com.sample.tmdb.data.paging

import android.content.Context
import com.sample.tmdb.common.model.TMDbItem
import com.sample.tmdb.data.response.NetworkTMDbWrapper
import com.sample.tmdb.data.response.TMDbItemResponse
import com.sample.tmdb.domain.paging.BasePagingSource
import org.junit.Before
import org.mockito.Mock

abstract class BasePagingPagingSourceTest<T : TMDbItem, R : TMDbItemResponse> {

    @Mock
    protected lateinit var context: Context

    protected lateinit var pagingSource: BasePagingSource<T>

    protected abstract fun getPagingDataSource(): BasePagingSource<T>

    protected abstract fun mockApiResponse()

    protected abstract suspend fun getApiCall(): NetworkTMDbWrapper<R>

    @Before
    fun setup() {
        pagingSource = getPagingDataSource()
    }
}
