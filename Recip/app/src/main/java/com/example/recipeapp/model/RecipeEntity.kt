package com.example.recipeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val recipeId: Long? = null,
    val name: String,
    val type: String,
    val serves: Int,
    val difficulty: String,
    val ingredients: List<String>,
    val preparationSteps: List<String>,
    val image: String
)
