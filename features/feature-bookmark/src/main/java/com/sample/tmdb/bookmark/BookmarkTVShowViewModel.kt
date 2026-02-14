package com.sample.tmdb.bookmark

import com.sample.tmdb.common.base.BaseRepository
import com.sample.tmdb.common.base.BaseViewModel
import com.sample.tmdb.domain.model.TVShow
import com.sample.tmdb.domain.utils.BookmarkTVShow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkTVShowViewModel @Inject constructor(@BookmarkTVShow  repository: BaseRepository<List<TVShow>, Nothing>) :
    BaseViewModel<List<TVShow>, Nothing>(repository)
