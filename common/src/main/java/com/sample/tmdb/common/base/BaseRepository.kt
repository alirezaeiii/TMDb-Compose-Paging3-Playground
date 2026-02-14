package com.sample.tmdb.common.base

import android.content.Context
import com.sample.tmdb.common.utils.Async
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

abstract class BaseRepository<T>(context: Context, ioDispatcher: CoroutineDispatcher) :
    CoreBaseRepository<T>(context, ioDispatcher) {

    protected abstract suspend fun getSuccessResult(): T

    fun getResult(isRefreshing: Boolean = false): Flow<Async<T>> = execute(isRefreshing) {
        getSuccessResult()
    }
}
