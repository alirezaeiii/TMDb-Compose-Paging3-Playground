package com.sample.tmdb.common.base

import com.sample.tmdb.common.repository.LanguageRepository

open class BaseViewModelWithInit<T>(repository: BaseRepository<T>, languageRepository: LanguageRepository) :
    BaseViewModel<T>(repository, languageRepository) {

    init {
        refresh()
    }
}
