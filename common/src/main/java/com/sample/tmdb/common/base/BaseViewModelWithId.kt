package com.sample.tmdb.common.base

open class BaseViewModelWithId<T, S>(private val repository: BaseRepositoryWithId<T, S>, private val id: S) :
    CoreBaseViewModel<T>() {

    init {
        refresh()
    }

    override fun refresh(isUserRefresh: Boolean) {
        execute {
            repository.getResult(id, isUserRefresh)
        }
    }
}
