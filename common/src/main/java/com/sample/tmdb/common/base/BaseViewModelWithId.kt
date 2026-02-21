package com.sample.tmdb.common.base

import com.sample.tmdb.common.repository.LanguageRepository

open class BaseViewModelWithId<T, S>(
    private val repository: BaseRepositoryWithId<T, S>,
    private val id: S,
    languageRepository: LanguageRepository? = null,
) : CoreBaseViewModel<T>(languageRepository) {

    init {
        refresh()
    }

    override fun refresh(isUserRefresh: Boolean) {
        execute {
            repository.getResult(id, isUserRefresh)
        }
    }
}
