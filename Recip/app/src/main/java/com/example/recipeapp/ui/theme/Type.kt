package com.example.recipeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.recipeapp.R


val ROBOTO = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_regular, FontWeight.Normal)
)


// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = ROBOTO,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = ROBOTO,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    displaySmall = TextStyle(
        fontFamily = ROBOTO,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),


    labelSmall = TextStyle(
        fontFamily = ROBOTO,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = ROBOTO,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

)