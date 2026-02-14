package com.sample.tmdb.common.base

open class TMDbViewModel<T>(repository: BaseRepository<T>) : BaseViewModel<T>(repository) {

    init {
        refresh()
    }
}
