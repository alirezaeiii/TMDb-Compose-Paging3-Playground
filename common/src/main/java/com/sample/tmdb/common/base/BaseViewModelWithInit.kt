package com.sample.tmdb.common.base

open class BaseViewModelWithInit<T>(repository: BaseRepository<T>) : BaseViewModel<T>(repository) {

    init {
        refresh()
    }
}
