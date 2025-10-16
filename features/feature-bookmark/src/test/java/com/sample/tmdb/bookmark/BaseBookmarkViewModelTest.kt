package com.sample.tmdb.bookmark

import com.sample.tmdb.common.base.BaseRepository
import com.sample.tmdb.common.base.BaseViewModel
import com.sample.tmdb.common.test.TestCoroutineRule
import com.sample.tmdb.common.utils.Resource
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test

abstract class BaseBookmarkViewModelTest<T> {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    protected val repository = mockk<BaseRepository<List<T>>>()

    lateinit var viewModel: BaseViewModel<List<T>>

    abstract fun initViewModel()

    @Test
    fun `load bookmarks`() {
        every { repository.getResult(any()) } returns flowOf(Resource.Loading)
        viewModel.refresh()
        assertEquals(Resource.Loading, viewModel.stateFlow.value)
    }

    @Test
    fun `load bookmarks success`() {
        every { repository.getResult(any()) } returns flowOf(Resource.Success(emptyList()))
        viewModel.refresh()
        assertEquals(Resource.Success(emptyList<T>()), viewModel.stateFlow.value)
    }

    @Test
    fun `load bookmarks failed`() {
        every { repository.getResult(any()) } returns flowOf(Resource.Error(""))
        viewModel.refresh()
        assertEquals(Resource.Error(""), viewModel.stateFlow.value)
    }
}
