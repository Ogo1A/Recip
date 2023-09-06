package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.recipeapp.ui.theme.RecipeAppTheme
import com.example.recipeapp.viewmodel.RoomRecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val roomRecipeViewModel: RoomRecipeViewModel by viewModels()

        setContent {
            RecipeAppTheme {
                RecipeApp(
                    roomRecipeViewModel = roomRecipeViewModel
                )
            }
        }
    }
}



