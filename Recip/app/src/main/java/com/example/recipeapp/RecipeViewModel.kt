package com.example.recipeapp

import androidx.lifecycle.ViewModel
import com.example.recipeapp.model.Recipe
import com.example.recipeapp.model.RecipeEntity
import com.example.recipeapp.viewmodel.RoomRecipeViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel(
) : ViewModel(

) {

    private val _uiState = MutableStateFlow(Recipe())

    var uiState: StateFlow<Recipe> = _uiState.asStateFlow()
        private set




    fun updateRecipe(id: Long) {

        _uiState.update { currentState ->
            currentState.copy(
                id = id
            )


        }
    }



}