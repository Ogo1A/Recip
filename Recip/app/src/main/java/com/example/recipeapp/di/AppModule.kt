package com.example.recipeapp.di

import android.app.Application
import com.example.recipeapp.data.AppDatabase
import com.example.recipeapp.data.RecipeDao
import com.example.recipeapp.data.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideNoteRepository(
    recipeDao: RecipeDao): RecipeRepository {
        return RecipeRepository(recipeDao = recipeDao)
    }


    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppDatabase {
        return AppDatabase.getInstance(context = app)
    }


    @Singleton
    @Provides
    fun provideRecipeDao(appDatabase: AppDatabase): RecipeDao {
        return appDatabase.recipeDao()
    }

}