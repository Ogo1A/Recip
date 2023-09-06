package com.example.recipeapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.recipeapp.model.RecipeEntity
import com.example.recipeapp.typeconverters.RecipeTypeConverters


@Database(entities = [RecipeEntity::class], version = 1)
@TypeConverters(RecipeTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recipeDao() : RecipeDao


    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "recipe.db"
                )
                    .createFromAsset("database/recipes.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }

}