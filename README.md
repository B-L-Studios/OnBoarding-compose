# OnBoarding-compose
A customizable jetpack compose library for building onboarding screen quickly and easily

![Cover](https://raw.githubusercontent.com/B-L-Studios/OnBoarding-compose/main/art/banner.png)

## Getting Started

[![Release](https://jitpack.io/v/B-L-Studios/OnBoarding-compose.svg)](https://jitpack.io/#B-L-Studios/OnBoarding-compose)
[![](https://jitpack.io/v/B-L-Studios/OnBoarding-compose/month.svg)](https://jitpack.io/#B-L-Studios/OnBoarding-compose)
![GitHub](https://img.shields.io/github/license/B-L-Studios/OnBoarding-compose)
[![Project Status: Active – The project has reached a stable, usable state and is being actively developed.](https://www.repostatus.org/badges/latest/active.svg)](https://www.repostatus.org/#active)

## Table of Contents

- [Materials](#materials) - Used libraries
- [Installation](#installation) - How to install
- [Usage](#usage) - How to use
- [OnBoardingScreen Parameters](#onboardingscreen-parameters) - Customizing
- [Developers](#developers) - Developers
- [License](#license) - License

## Materials

- Jetpack compose
- Material 3
- Accompanist Pager

## Installation

Add the following code to your project's _root_ `settings.gradle` file:

<details open>
  <summary>groovy - settings.gradle</summary>

```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```
</details>

<details>
  <summary>kotlin - settings.gradle.kts</summary>  

```kotlin
repositories {
    maven ( url = "https://jitpack.io" )
}
```
</details>

Next, add the dependency below to your _module_'s `build.gradle` file:

<details open>
  <summary>groovy - build.gradle(:module-name)</summary>

```gradle
dependencies {
    implementation "com.github.B-L-Studios:OnBoarding-compose:LATEST_VERSION"
}
```
</details>

<details>
  <summary>kotlin - build.gradle.kts(:module-name)</summary>  

```kotlin
dependencies {
    implementation("com.github.B-L-Studios:OnBoarding-compose:LATEST_VERSION")
}
```
</details>

## Usage

1. Create a list of OnBoardingPages using `OnBoardingPage` class:

```kotlin
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
```

2. Add your list to `OnBoardingScreen` class and use it for the OnBoardingView:

```kotlin
OnBoardingScreen(
    items = onBoardingPages,
    onNextClicked = {}
)
```

Example is in the [source code](https://github.com/B-L-Studios/OnBoarding-compose/blob/main/app/src/main/java/com/bls/onboardingcompose/MainActivity.kt).

## OnBoardingScreen Parameters

| Name                              | Type                      | Default                        |
| ----------------------            | ------------------------- | ------------------------------ |
| 	items	                        | 	`List<OnBoardingPage>`	| 	REQUIRED                     |
| 	skipText	                    | 	`String`                | 	"Skip"	                     |
| 	skipTextStyle	                | 	`TextStyle`             | 		                         |
| 	selectedIndicatorColor	        | 	`Color`                 | 	Black	                     |
| 	unSelectedIndicatorColor	    | 	`Color`                 | 	LightGray                    |
| 	indicatorHeight	                | 	`Dp`	                | 	10.dp	                     |
| 	spaceBetweenIndicators    	    | 	`Dp`	                | 	12.dp	                     |
| 	onNextClicked	                | 	`() -> Unit`            | 	REQUIRED                     |
| 	nextButtonShape	                | 	`Shape`                 | 	RoundedCornerShape(16.0.dp)	 |
| 	nextButtonBackgroundColor	    | 	`Color`                 | 	Black	                     |
| 	nextButtonIconColor	            | 	`Color`                 | 	white	                     |
| 	imageModifier	                | 	`Modifier`              | 	Modifier	                 |
| 	imageScale	                    | 	`ContentScale`          | 	ContentScale.Fit	         |
| 	titleModifier	                | 	`Modifier`              | 	Modifier	                 |
| 	titleStyle	                    | 	`TextStyle`             | 		                         |
| 	titleAlign	                    | 	`TextAlign`             | 	TextAlign.Center	         |
| 	descriptionModifier	            | 	`Modifier`              | 	Modifier	                 |
| 	descriptionStyle		        | 	`TextStyle`             | 		                         |
| 	descriptionAlign	            | 	`TextAlign`             | 	TextAlign.Center	         |
| 	spaceBetweenImageAndTitle	    | 	`Dp`	                | 	16.dp	                     |
| 	spaceBetweenTitleAndDescription	| 	`Dp`	                | 	8.dp	                     |
| 	contentPadding                  | 	`Dp`	                | 	8.dp	                     |


## Developers 

- [@louayyy99](https://www.github.com/louayyy99)

# License

    Copyright 2023 Louay Labidi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

**If you like the library, consider starring and sharing it with your colleagues.**
