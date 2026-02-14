package com.sample.tmdb.feed

import com.sample.tmdb.common.model.TMDbItem
import com.sample.tmdb.common.test.TestCoroutineRule
import com.sample.tmdb.common.utils.Async
import com.sample.tmdb.common.utils.ViewState
import com.sample.tmdb.domain.model.FeedWrapper
import com.sample.tmdb.domain.repository.BaseFeedRepository
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test

abstract class BaseFeedViewModelTest<T : TMDbItem> {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    protected val repository = mockk<BaseFeedRepository<T>>()

    protected lateinit var viewModel: BaseFeedViewModel<T>

    protected abstract fun initViewModel()

    @Test
    fun `load feeds`() {
        every { repository.getResult() } returns flowOf(Async.Loading())
        initViewModel()
        assertEquals(ViewState<Nothing>(isLoading = true), viewModel.state.value)
    }

    @Test
    fun `load feeds success`() {
        every { repository.getResult() } returns flowOf(Async.Success(emptyList()))
        initViewModel()
        assertEquals(ViewState(emptyList<FeedWrapper>()), viewModel.state.value)
    }

    @Test
    fun `load feeds failed`() {
        every { repository.getResult() } returns flowOf(Async.Error("error"))
        initViewModel()
        assertEquals(ViewState<Nothing>(error = "error"), viewModel.state.value)
    }
}
