package com.sample.tmdb.bookmark

import com.sample.tmdb.domain.model.Movie

class BookmarkMovieViewModelTest : BaseBookmarkViewModelTest<Movie>() {

    override fun initViewModel() {
        viewModel = BookmarkMovieViewModel(repository)
    }
}
