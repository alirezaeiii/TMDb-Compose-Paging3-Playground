package com.sample.tmdb.common.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sample.tmdb.common.base.BaseViewModel
import com.sample.tmdb.common.ui.component.ErrorScreen
import com.sample.tmdb.common.ui.component.TMDbProgressBar

@Composable
fun <T> Content(viewModel: BaseViewModel<T>, successScreen: @Composable (T) -> Unit) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    when {
        state.items != null -> {
            successScreen(state.items)
        }

        state.isLoading -> {
            TMDbProgressBar()
        }

        state.error.isNotEmpty() -> {
            ErrorScreen(
                message = state.error,
                modifier = Modifier.fillMaxSize(),
                refresh = viewModel::refresh,
            )
        }
    }
}
