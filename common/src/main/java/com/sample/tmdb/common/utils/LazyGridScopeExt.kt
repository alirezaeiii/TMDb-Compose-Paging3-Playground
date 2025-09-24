package com.sample.tmdb.common.utils

import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.runtime.Composable

fun LazyGridScope.fullSpanGridItem(content: @Composable () -> Unit) {
    item(span = { GridItemSpan(maxLineSpan) }) {
        content()
    }
}
