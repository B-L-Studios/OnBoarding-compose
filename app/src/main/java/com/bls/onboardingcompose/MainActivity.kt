package com.bls.onboardingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bls.compose_onboarding.OnBoardingScreen
import com.bls.compose_onboarding.data.OnBoardingPage
import com.bls.onboardingcompose.ui.theme.OnBoardingComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnBoardingComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    OnBoardingScreen(
                        items = onBoardingPages,
                        onNextClicked = {

                        }
                    )
                }
            }
        }
    }
}

val onBoardingPages = listOf(
    OnBoardingPage(
        image = R.drawable.android,
        title = "Travel Compose",
        description = "Travel-compose is a library that helps you create onboarding screens in your app",
    ),
    OnBoardingPage(
        image = R.drawable.team,
        title = "How to use",
        description = "Just add the library to your project and use the OnBoardingScreen composable",
    ),
    OnBoardingPage(
        image = R.drawable.star,
        title = "Support me",
        description = "If you like the library, please star it on GitHub",
    ),
)