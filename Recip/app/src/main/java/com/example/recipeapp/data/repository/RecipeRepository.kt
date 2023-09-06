package com.example.recipeapp.data.repository

import com.example.recipeapp.data.RecipeDao
import com.example.recipeapp.model.RecipeEntity
import kotlinx.coroutines.flow.Flow

class  RecipeRepository(
    private val recipeDao: RecipeDao
) {

    fun getAllFlow(): Flow<List<RecipeEntity>> = recipeDao.getAllFlow()
    fun getRecipe(id:Long): RecipeEntity = recipeDao.getRecipe(id)
    suspend fun insert(recipe: RecipeEntity) = recipeDao.insert(recipe = recipe)
    suspend fun update(recipe: RecipeEntity) = recipeDao.update(recipe = recipe)
    suspend fun delete(recipe: RecipeEntity) = recipeDao.delete(recipe = recipe)

}