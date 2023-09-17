package com.bls.compose_onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.compose_onboarding.data.OnBoardingPage
import com.bls.compose_onboarding.sections.BottomSection
import com.bls.compose_onboarding.sections.PagerSection
import com.bls.compose_onboarding.sections.TopSection
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

/**
 * ONBOARDING SCREEN
 * @param items List of [OnBoardingPage] to be displayed
 * @param skipText Text to be displayed on the skip button
 * @param skipTextStyle Style of the skip button text
 * @param selectedIndicatorColor Color of the selected indicator
 * @param unSelectedIndicatorColor Color of the unselected indicator
 * @param indicatorHeight Height of the indicator
 * @param spaceBetweenIndicators Space between the indicators
 * @param onNextClicked Function to be called when the next button is clicked
 * @param nextButtonShape Shape of the next button
 * @param nextButtonBackgroundColor Background color of the next button
 * @param nextButtonIconColor Icon color of the next button
 * @param imageModifier Modifier for the image
 * @param imageScale Scale of the image
 * @param titleModifier Modifier for the title
 * @param titleStyle Style of the title
 * @param titleAlign Alignment of the title
 * @param descriptionModifier Modifier for the description
 * @param descriptionStyle Style of the description
 * @param descriptionAlign Alignment of the description
 * @param spaceBetweenImageAndTitle Space between the image and the title
 * @param spaceBetweenTitleAndDescription Space between the title and the description
 * @param contentPadding Padding of the content
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    items: List<OnBoardingPage>,
    skipText: String = "Skip",
    skipTextStyle: TextStyle = TextStyle(),
    selectedIndicatorColor: Color = Color.Black,
    unSelectedIndicatorColor: Color = Color.LightGray,
    indicatorHeight: Dp = 10.dp,
    spaceBetweenIndicators: Dp = 12.dp,
    onNextClicked: () -> Unit,
    nextButtonShape: Shape = RoundedCornerShape(16.0.dp),
    nextButtonBackgroundColor: Color = Color.Black,
    nextButtonIconColor: Color = Color.White,
    @SuppressLint("ModifierParameter") imageModifier: Modifier = Modifier,
    imageScale: ContentScale = ContentScale.Fit,
    titleModifier: Modifier = Modifier,
    titleStyle: TextStyle = TextStyle(
        fontSize = 24.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    ),
    titleAlign: TextAlign = TextAlign.Center,
    descriptionModifier: Modifier = Modifier,
    descriptionStyle: TextStyle = TextStyle(
        fontSize = 16.sp,
        color = Color.Black,
        fontWeight = FontWeight.Normal
    ),
    descriptionAlign: TextAlign = TextAlign.Center,
    spaceBetweenImageAndTitle: Dp = 16.dp,
    spaceBetweenTitleAndDescription: Dp = 8.dp,
    contentPadding: Dp = 8.dp,
) {
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()
    val showBackButton = pageState.currentPage > 0

    Column(
        modifier = Modifier
            .padding(contentPadding)
            .fillMaxSize()
    ) {
        TopSection(
            showBackButton = showBackButton,
            onBackClicked = {
                if (pageState.currentPage + 1 > 1)
                    scope.launch {
                        pageState.scrollToPage(pageState.currentPage - 1)
                    }
            },
            onSkipClicked = {
                if (pageState.currentPage + 1 < items.size)
                    scope.launch {
                        pageState.scrollToPage(items.size - 1)
                    }
            },
            text = skipText,
            textStyle = skipTextStyle
        )

        PagerSection(
            items = items,
            state = pageState,
            imageScale = imageScale,
            titleStyle = titleStyle,
            descriptionStyle = descriptionStyle,
            spaceBetweenImageAndTitle = spaceBetweenImageAndTitle,
            spaceBetweenTitleAndDescription = spaceBetweenTitleAndDescription,
            imageModifier = imageModifier,
            titleAlign = titleAlign,
            titleModifier = titleModifier,
            descriptionAlign = descriptionAlign,
            descriptionModifier = descriptionModifier
        )

        BottomSection(
            size = items.size,
            index = pageState.currentPage,
            selectedIndicatorColor = selectedIndicatorColor,
            unSelectedIndicatorColor = unSelectedIndicatorColor,
            indicatorHeight = indicatorHeight,
            spaceBetweenIndicators = spaceBetweenIndicators,
            onNextClicked = onNextClicked,
            nextButtonShape = nextButtonShape,
            nextButtonBackgroundColor = nextButtonBackgroundColor,
            nextButtonIconColor = nextButtonIconColor,
        )
    }
}