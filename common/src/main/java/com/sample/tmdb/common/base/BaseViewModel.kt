package com.sample.tmdb.common.base

import com.sample.tmdb.common.repository.LanguageRepository

open class BaseViewModel<T>(
    private val repository: BaseRepository<T>,
    languageRepository: LanguageRepository? = null,
) : CoreBaseViewModel<T>(languageRepository) {

    override fun refresh(isUserRefresh: Boolean, languageCode: String?) {
        execute(languageCode) {
            repository.getResult(isUserRefresh)
        }
    }
}
