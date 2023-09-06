package com.example.recipeapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class OnBoardingPage(
   @DrawableRes val image: Int,
   @StringRes val text: Int
) {

    object First: OnBoardingPage(
        image = R.drawable.onboarding_one,
        text = R.string.on_boarding_one_text
    )

    object Second: OnBoardingPage(
        image = R.drawable.onboarding_one,
        text = R.string.on_boarding_two_text
    )

}
