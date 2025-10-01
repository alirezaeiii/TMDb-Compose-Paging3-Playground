package com.sample.tmdb.common.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun navigationBarPadding() = WindowInsets.navigationBars.getBottom(LocalDensity.current).toDp().dp
