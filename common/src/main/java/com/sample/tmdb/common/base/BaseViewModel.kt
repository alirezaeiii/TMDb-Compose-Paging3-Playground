package com.sample.tmdb.common.base

open class BaseViewModel<T>(private val repository: BaseRepository<T>) : CoreBaseViewModel<T>() {

    override fun refresh(isUserRefresh: Boolean) {
        execute {
            repository.getResult(isUserRefresh)
        }
    }
}
