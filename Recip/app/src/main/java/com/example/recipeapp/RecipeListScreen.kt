package com.example.recipeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.recipeapp.model.RecipeEntity
import com.example.recipeapp.navigation.Screens
import com.example.recipeapp.viewmodel.RoomRecipeViewModelAbstract


//@Composable
//fun RecipeList(
//    viewModel: RecipeViewModel,
//    cardClick: () -> Unit
//) {
//
//    val recipes = remember {
//        RecipeDatasource.recipes
//    }
//
//
//    LazyColumn(modifier = Modifier
//        .padding(16.dp)) {
//        items(recipes) { recipe ->
//            val foodIndex = recipe.id
//            RecipeCard(
//                recipe = recipe,
//                modifier = Modifier.height(120.dp)
//            ) {
//                viewModel.updateRecipe(foodIndex)
//                cardClick()
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//    }
//
//
//}

@Composable
fun RecipeList(
    viewModel: RecipeViewModel,
    cardClick: () -> Unit,
    roomRecipeViewModelAbstract: RoomRecipeViewModelAbstract,
    navHostController: NavHostController
) {

    val recipeListState = roomRecipeViewModelAbstract.recipeListFlow.collectAsState(
        initial = listOf()
    )

    var clickedCardId = 0

    LazyColumn(modifier = Modifier
        .padding(16.dp)) {
        items(recipeListState.value.size) { index ->
            val recipe = recipeListState.value[index]

            RecipeCard(
                recipe = recipe,
                modifier = Modifier.height(120.dp),
                cardClick = {
                    viewModel.updateRecipe(roomRecipeViewModelAbstract.getRecipe(recipe.recipeId!!).recipeId!!)
                    navHostController.navigate(Screens.Recipe.name)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    //recipe: Recipe,
    recipe: RecipeEntity,
    cardClick: () -> Unit

) {
    Card(
        modifier = modifier,
        onClick = cardClick
    ) {

        Row(
            modifier
                .height(120.dp)
                .fillMaxWidth()) {
            AsyncImage(
                model = recipe.image,
                contentDescription = null,
                modifier
                    .height(120.dp)
                    .width(120.dp),
                contentScale = ContentScale.Crop

            )

            Spacer(modifier = Modifier.width(20.dp))

            Column {

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text =  recipe.name,
                    style = MaterialTheme.typography.displayMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = recipe.difficulty
                )

            }
        }

    }

}




//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RecipeCard(
//    modifier: Modifier = Modifier,
//    //recipe: Recipe,
//    recipe: Recipe,
//    cardClick: () -> Unit
//
//) {
//    Card(
//        modifier = modifier,
//        onClick = cardClick
//    ) {
//
//        Row(
//            modifier
//                .height(120.dp)
//                .fillMaxWidth()) {
//            Image(
//                painter = painterResource(id = recipe.image),
//                contentDescription = null,
//                modifier
//                    .height(120.dp)
//                    .width(120.dp),
//                contentScale = ContentScale.Crop
//
//            )
//
//            Spacer(modifier = Modifier.width(20.dp))
//
//            Column {
//
//                Spacer(modifier = Modifier.height(32.dp))
//
//                Text(
//                    text =  recipe.name,
//                    style = MaterialTheme.typography.displayMedium
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = recipe.difficulty
//                )
//
//            }
//        }
//
//    }
//
//}


@Preview
@Composable
fun RecipeListScreenPreview() {

}
    
