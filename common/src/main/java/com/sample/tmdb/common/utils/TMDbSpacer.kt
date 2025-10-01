package com.sample.tmdb.common.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sample.tmdb.common.ui.Dimens.TMDb_56_dp

@Composable
fun TMDbSpacer() {
    Spacer(
        Modifier.windowInsetsTopHeight(
            WindowInsets.statusBars.add(WindowInsets(top = TMDb_56_dp)),
        ),
    )
}
