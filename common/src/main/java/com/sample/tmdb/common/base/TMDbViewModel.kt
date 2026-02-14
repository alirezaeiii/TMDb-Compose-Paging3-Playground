package com.sample.tmdb.common.base

open class TMDbViewModel<T, S>(repository: BaseRepository<T, S>, id: S? = null) : BaseViewModel<T, S>(repository, id) {
    init {
        refresh()
    }
}
