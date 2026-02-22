package com.sample.tmdb.bookmark

import com.sample.tmdb.domain.model.TVShow

class BookmarkTVShowViewModelTest : BaseBookmarkViewModelTest<TVShow>() {

    override fun getViewModel() = BookmarkTVShowViewModel(repository, languageRepository)
}
