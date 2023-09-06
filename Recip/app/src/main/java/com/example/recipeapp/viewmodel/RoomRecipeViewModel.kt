package com.example.recipeapp.viewmodel

import androidx.compose.runtime.rememberCompositionContext
import androidx.lifecycle.ViewModel
import com.example.recipeapp.RecipeViewModel
import com.example.recipeapp.data.repository.RecipeRepository
import com.example.recipeapp.model.RecipeEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface RoomRecipeViewModelAbstract{
    val recipeListFlow: Flow<List<RecipeEntity>>
    fun addRecipe(recipe: RecipeEntity)
    fun updateRecipe(recipe: RecipeEntity)
    fun deleteRecipe(recipe: RecipeEntity)
    fun getRecipe(id:Long): RecipeEntity
}

@HiltViewModel
class RoomRecipeViewModel
   @Inject constructor (
    private val recipeRepository: RecipeRepository
    ): ViewModel(), RoomRecipeViewModelAbstract {

    private val ioScope = CoroutineScope(Dispatchers.IO)


    override val recipeListFlow: Flow<List<RecipeEntity>> = recipeRepository.getAllFlow()

    override fun getRecipe(id: Long): RecipeEntity {
       return recipeRepository.getRecipe(id)
    }


    override fun addRecipe(recipe: RecipeEntity) {
        ioScope.launch {
            recipeRepository.insert(recipe = recipe)
        }
    }

    override fun updateRecipe(recipe: RecipeEntity) {
        ioScope.launch {
            recipeRepository.update(recipe = recipe)
        }
    }

    override fun deleteRecipe(recipe: RecipeEntity) {
        ioScope.launch {
            recipeRepository.delete(recipe = recipe)
        }
    }




}