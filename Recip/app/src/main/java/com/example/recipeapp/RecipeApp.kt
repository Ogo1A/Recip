package com.example.recipeapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.navigation.Screens
import com.example.recipeapp.viewmodel.RoomRecipeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeAppBar(
    canNavigateBack: Boolean,
    currentScreen: Screens,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = currentScreen.name) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: RecipeViewModel = viewModel(),
    roomRecipeViewModel: RoomRecipeViewModel
) {

    val recipeListState = roomRecipeViewModel.recipeListFlow.collectAsState(
        initial = listOf()
    )


//    LaunchedEffect(key1 = true) {
//        if (recipeListState.value.isEmpty()) {
//            RecipeDatasource.recipes.forEach { recipe ->
//                roomRecipeViewModel.addRecipe(recipe)
//            }
//        }
//    }


    val recipeState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route ?: Screens.Recipes.name
    )

    Scaffold(
        topBar = {
            RecipeAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                currentScreen = currentScreen
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            startDestination = Screens.Welcome.name
        ) {


            composable(route = Screens.Welcome.name) {
                WelcomeScreen(
                    finishClicked = {
                        navController.popBackStack()
                        navController.navigate(Screens.Recipes.name)
                    }
                )
            }


            composable(route = Screens.Recipes.name) {
                RecipeList(
                    viewModel = viewModel,
                    cardClick = {
                        navController.navigate(Screens.Recipe.name)
                    },
                    roomRecipeViewModelAbstract = roomRecipeViewModel,
                    navHostController = navController
                )
            }

            composable(route = Screens.Recipe.name) {
                RecipeScreen(viewModel = viewModel,
                roomRecipeViewModelAbstract = roomRecipeViewModel)
            }


        }



    }


}

