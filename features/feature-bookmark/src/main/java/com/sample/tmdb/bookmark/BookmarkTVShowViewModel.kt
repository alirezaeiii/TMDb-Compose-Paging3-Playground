package com.sample.tmdb.bookmark

import com.sample.tmdb.common.base.BaseRepository
import com.sample.tmdb.common.base.BaseViewModel
import com.sample.tmdb.common.repository.LanguageRepository
import com.sample.tmdb.domain.model.TVShow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkTVShowViewModel @Inject constructor(
    repository: BaseRepository<List<TVShow>>,
    languageRepository: LanguageRepository,
) : BaseViewModel<List<TVShow>>(repository, languageRepository)
