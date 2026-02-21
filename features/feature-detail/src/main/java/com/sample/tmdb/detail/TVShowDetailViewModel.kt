package com.sample.tmdb.detail

import androidx.lifecycle.SavedStateHandle
import com.sample.tmdb.common.repository.LanguageRepository
import com.sample.tmdb.domain.model.TVShow
import com.sample.tmdb.domain.model.TVShowDetails
import com.sample.tmdb.domain.repository.BaseDetailRepository
import com.sample.tmdb.domain.repository.BookmarkDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TVShowDetailViewModel @Inject constructor(
    bookmarkRepository: BookmarkDetailsRepository<TVShow>,
    repository: BaseDetailRepository<TVShowDetails>,
    languageRepository: LanguageRepository,
    savedStateHandle: SavedStateHandle,
) : BaseDetailViewModel<TVShowDetails, TVShow>(bookmarkRepository, repository, languageRepository, savedStateHandle)
