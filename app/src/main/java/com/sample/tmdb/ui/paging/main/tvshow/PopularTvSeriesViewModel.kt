package com.sample.tmdb.ui.paging.main.tvshow

import com.sample.tmdb.core.data.repository.PopularTvSeriesPagingRepository
import com.sample.tmdb.core.domain.model.TVShow
import com.sample.tmdb.ui.paging.main.BaseMainPagingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularTvSeriesViewModel @Inject constructor(repository: PopularTvSeriesPagingRepository) :
    BaseMainPagingViewModel<TVShow>(repository)