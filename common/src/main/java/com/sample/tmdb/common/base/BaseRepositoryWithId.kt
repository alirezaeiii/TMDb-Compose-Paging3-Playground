package com.sample.tmdb.common.base

import android.content.Context
import com.sample.tmdb.common.utils.Async
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

abstract class BaseRepositoryWithId<T, S>(context: Context, ioDispatcher: CoroutineDispatcher) :
    CoreBaseRepository<T>(context, ioDispatcher) {

    protected abstract suspend fun getSuccessResult(id: S): T

    fun getResult(id: S, isRefreshing: Boolean = false): Flow<Async<T>> = execute(isRefreshing) {
        getSuccessResult(id)
    }
}
