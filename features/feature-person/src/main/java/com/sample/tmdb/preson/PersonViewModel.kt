package com.sample.tmdb.preson

import androidx.lifecycle.SavedStateHandle
import com.sample.tmdb.common.MainDestinations
import com.sample.tmdb.common.base.BaseRepositoryWithId
import com.sample.tmdb.common.base.BaseViewModelWithId
import com.sample.tmdb.domain.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    repository: BaseRepositoryWithId<Person, String>,
    savedStateHandle: SavedStateHandle,
) : BaseViewModelWithId<Person, String>(
    repository,
    savedStateHandle[MainDestinations.TMDB_PERSON_KEY]!!,
)
