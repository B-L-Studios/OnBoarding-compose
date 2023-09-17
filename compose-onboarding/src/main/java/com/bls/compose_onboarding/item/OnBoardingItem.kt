package com.bls.compose_onboarding.item

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.bls.compose_onboarding.data.OnBoardingPage

/**
 * ONBOARDING ITEM
 */
@Composable
fun OnBoardingItem(
    page: OnBoardingPage,
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
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = page.image),
            contentScale = imageScale,
            contentDescription = null,
            modifier = imageModifier
        )

        Spacer(modifier = Modifier.height(spaceBetweenImageAndTitle))

        Text(
            text = page.title,
            modifier = titleModifier,
            textAlign = titleAlign,
            style = titleStyle
        )

        Spacer(modifier = Modifier.height(spaceBetweenTitleAndDescription))

        Text(
            text = page.description,
            modifier = descriptionModifier,
            textAlign = descriptionAlign,
            style = descriptionStyle
        )
    }
}