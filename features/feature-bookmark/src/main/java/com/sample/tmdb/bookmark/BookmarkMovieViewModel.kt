package com.sample.tmdb.bookmark

import com.sample.tmdb.common.base.BaseRepository
import com.sample.tmdb.common.base.BaseViewModel
import com.sample.tmdb.common.repository.LanguageRepository
import com.sample.tmdb.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkMovieViewModel @Inject constructor(
    repository: BaseRepository<List<Movie>>,
    languageRepository: LanguageRepository,
) : BaseViewModel<List<Movie>>(repository, languageRepository)
