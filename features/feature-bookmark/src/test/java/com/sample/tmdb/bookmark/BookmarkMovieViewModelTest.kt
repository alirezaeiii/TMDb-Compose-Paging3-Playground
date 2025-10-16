package com.sample.tmdb.bookmark

import com.sample.tmdb.domain.model.Movie
import org.junit.Before

class BookmarkMovieViewModelTest : BaseBookmarkViewModelTest<Movie>() {

    @Before
    override fun initViewModel() {
        viewModel = BookmarkMovieViewModel(repository)
    }
}
