package com.sample.tmdb.common.utils

data class ViewState<T>(
    val items: T? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String = "",
    val isWarning: Boolean = false,
)
