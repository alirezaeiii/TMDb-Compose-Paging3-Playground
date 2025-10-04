package com.sample.tmdb.credit

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import com.sample.tmdb.common.model.Credit
import com.sample.tmdb.common.ui.Dimens.TMDb_120_dp
import com.sample.tmdb.common.ui.Dimens.TMDb_6_dp
import com.sample.tmdb.common.ui.Dimens.TMDb_8_dp
import com.sample.tmdb.common.ui.component.DestinationBar
import com.sample.tmdb.common.ui.component.PersonCard
import com.sample.tmdb.common.utils.TMDbSpacer
import com.sample.tmdb.common.utils.fullSpanGridItem
import com.sample.tmdb.common.utils.navigationBarPadding

@Composable
fun CreditScreen(
    @StringRes resourceId: Int,
    upPress: () -> Unit,
    onPersonClicked: (person: Credit) -> Unit,
    items: List<Credit>,
    testPainter: Painter? = null,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(TMDb_120_dp),
        contentPadding =
        PaddingValues(
            start = TMDb_6_dp,
            end = TMDb_6_dp,
            top = TMDb_6_dp,
            bottom = navigationBarPadding().plus(TMDb_8_dp),
        ),
        content = {
            fullSpanGridItem {
                TMDbSpacer()
            }

            items(items.size) { index ->
                PersonCard(
                    person = items[index],
                    onPersonClicked = onPersonClicked,
                    testPainter = testPainter,
                )
            }
        },
    )
    DestinationBar(title = stringResource(resourceId), upPress = upPress::invoke)
}
