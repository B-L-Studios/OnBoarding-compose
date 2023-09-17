package com.bls.compose_onboarding.sections

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.bls.compose_onboarding.data.OnBoardingPage
import com.bls.compose_onboarding.item.OnBoardingItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

/**
 * PAGER SECTION
 */
@ExperimentalPagerApi
@Composable
fun ColumnScope.PagerSection(
    items: List<OnBoardingPage>,
    state: PagerState,
    imageScale: ContentScale,
    @SuppressLint("ModifierParameter") imageModifier: Modifier,
    titleStyle: TextStyle,
    titleAlign: TextAlign,
    titleModifier: Modifier,
    descriptionStyle: TextStyle,
    descriptionAlign: TextAlign,
    descriptionModifier: Modifier,
    spaceBetweenImageAndTitle: Dp,
    spaceBetweenTitleAndDescription: Dp,

    ) {
    HorizontalPager(
        modifier = Modifier.weight(1f),
        count = items.size,
        state = state
    ) { page ->
        OnBoardingItem(
            page = items[page],
            imageScale = imageScale,
            titleStyle = titleStyle,
            descriptionStyle = descriptionStyle,
            spaceBetweenImageAndTitle = spaceBetweenImageAndTitle,
            spaceBetweenTitleAndDescription = spaceBetweenTitleAndDescription,
            imageModifier = imageModifier,
            titleAlign = titleAlign,
            titleModifier = titleModifier,
            descriptionAlign = descriptionAlign,
            descriptionModifier = descriptionModifier,
        )
    }
}
