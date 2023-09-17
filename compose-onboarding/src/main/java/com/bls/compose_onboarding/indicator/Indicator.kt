package com.bls.compose_onboarding.indicator

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * INDICATOR
 */
@Composable
fun Indicator(
    isSelected: Boolean,
    selectedIndicatorColor: Color,
    unSelectedIndicatorColor: Color,
    indicatorHeight: Dp,
) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 26.dp else indicatorHeight,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
    )

    Box(
        modifier = Modifier
            .sizeIn(
                minWidth = indicatorHeight,
                minHeight = indicatorHeight,
                maxWidth = 26.dp,
                maxHeight = 26.dp
            )
            .height(indicatorHeight)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) selectedIndicatorColor else unSelectedIndicatorColor
            )
    )
}

/**
 * INDICATORS
 */
@Composable
fun Indicators(
    size: Int,
    index: Int,
    selectedIndicatorColor: Color,
    unSelectedIndicatorColor: Color,
    indicatorHeight: Dp,
    spaceBetweenIndicators: Dp,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenIndicators),
    ) {
        repeat(size) {
            Indicator(
                isSelected = it == index,
                selectedIndicatorColor = selectedIndicatorColor,
                unSelectedIndicatorColor = unSelectedIndicatorColor,
                indicatorHeight = indicatorHeight
            )
        }
    }
}