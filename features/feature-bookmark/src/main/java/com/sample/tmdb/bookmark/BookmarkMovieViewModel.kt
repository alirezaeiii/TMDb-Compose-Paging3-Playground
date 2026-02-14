package com.sample.tmdb.bookmark

import com.sample.tmdb.common.base.BaseRepository
import com.sample.tmdb.common.base.BaseViewModel
import com.sample.tmdb.domain.model.Movie
import com.sample.tmdb.domain.utils.BookmarkMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkMovieViewModel @Inject constructor(@BookmarkMovie repository: BaseRepository<List<Movie>, Nothing>) :
    BaseViewModel<List<Movie>, Nothing>(repository)
