package com.sample.tmdb.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.tmdb.common.utils.Async
import com.sample.tmdb.common.utils.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

open class BaseViewModel<T>(private val repository: BaseRepository<T>, private val id: Any? = null) : ViewModel() {

    private val _state = MutableStateFlow(ViewState<T>(isLoading = true))
    val state = _state.asStateFlow()

    fun refresh(isUserRefresh: Boolean = false) {
        repository.getResult(isRefreshing = isUserRefresh, id = id).onEach { repoResource ->
            reduce(repoResource)
        }.launchIn(viewModelScope)
    }

    private fun reduce(resource: Async<T>) {
        when (resource) {
            is Async.Loading -> {
                _state.update {
                    it.copy(
                        isLoading = !resource.isRefreshing,
                        isRefreshing = resource.isRefreshing,
                        error = "",
                    )
                }
            }

            is Async.Success -> {
                _state.value = ViewState(items = resource.data)
            }

            is Async.Error -> {
                _state.update {
                    it.copy(
                        isLoading = false,
                        isRefreshing = false,
                        error = resource.message,
                        items = null,
                    )
                }
            }
        }
    }
}
