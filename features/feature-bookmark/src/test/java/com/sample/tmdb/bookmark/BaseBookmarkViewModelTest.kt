package com.sample.tmdb.bookmark

import com.sample.tmdb.common.base.BaseRepository
import com.sample.tmdb.common.base.BaseViewModel
import com.sample.tmdb.common.test.TestCoroutineRule
import com.sample.tmdb.common.utils.Async
import com.sample.tmdb.common.utils.ViewState
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

abstract class BaseBookmarkViewModelTest<T> {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    protected val repository = mockk<BaseRepository<List<T>, Nothing>>()

    private lateinit var viewModel: BaseViewModel<List<T>, Nothing>

    protected abstract fun getViewModel(): BaseViewModel<List<T>, Nothing>

    @Before
    fun setup() {
        viewModel = getViewModel()
    }

    @Test
    fun `load bookmarks`() {
        every { repository.getResult() } returns flowOf(Async.Loading())
        viewModel.refresh()
        assertEquals(ViewState<Nothing>(isLoading = true), viewModel.state.value)
    }

    @Test
    fun `load bookmarks success`() {
        every { repository.getResult() } returns flowOf(Async.Success(emptyList()))
        viewModel.refresh()
        assertEquals(ViewState(emptyList<T>()), viewModel.state.value)
    }

    @Test
    fun `load bookmarks failed`() {
        every { repository.getResult() } returns flowOf(Async.Error("error"))
        viewModel.refresh()
        assertEquals(ViewState<Nothing>(error = "error"), viewModel.state.value)
    }
}
