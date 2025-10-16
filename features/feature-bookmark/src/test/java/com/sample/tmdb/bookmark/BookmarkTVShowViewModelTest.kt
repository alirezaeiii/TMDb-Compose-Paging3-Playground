package com.sample.tmdb.bookmark

import com.sample.tmdb.domain.model.TVShow
import org.junit.Before

class BookmarkTVShowViewModelTest : BaseBookmarkViewModelTest<TVShow>() {

    @Before
    override fun initViewModel() {
        viewModel = BookmarkTVShowViewModel(repository)
    }
}
