package com.example.featurestartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.featurestartscreen.uiElements.CategoriesGrid
import com.example.featurestartscreen.uiElements.ProductList
import com.example.featurestartscreen.uiElements.SearchBar
import com.example.featurestartscreen.uiElements.bottomBar.MainScreenBottomBar
import com.example.sharedviewmodel.SharedViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenUI(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val viewModel = koinViewModel<SharedViewModel>()

    var searchValue by remember { mutableStateOf("") }
    var chosenCategory by remember { mutableStateOf(0L) }
    var parentCategoryId by remember { mutableStateOf(1L) }

    val productsData by viewModel.suggestedProducts.collectAsState(initial = emptyList())
    val categoriesData by viewModel.suggestedCategories.collectAsState(initial = emptyList())

    Scaffold(
        bottomBar = {
            MainScreenBottomBar(
                onNavigateToAddProduct = { navController.navigate("addProduct_screen") },
                onNavigateToAddCategory = { navController.navigate("addCategory_screen") },
                onBackIconPressed = { viewModel.returnBack() }
            )
        }, modifier = modifier.padding(horizontal = 14.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp)
                    .height(42.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                SearchBar(
                    searchValue = searchValue,
                    modifier = modifier.weight(1f),
                    onValueChanged = { changedValue -> searchValue = changedValue }
                )

            }

            Divider(
                modifier = modifier.padding(all = 14.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )

            if (categoriesData.isNotEmpty()) {
                CategoriesGrid(
                    categoriesList = categoriesData,
                    viewModel = viewModel
//                onCategoryClick = {  },
//                onCategoryLongClick = {
//                    /*TODO*/
//                }
                )

                Divider(
                    modifier = modifier.padding(all = 14.dp),
                    thickness = 1.dp,
                    color = Color.LightGray
                )
            }


            //TODO убрать фильтр, это для теста
            ProductList(
                products = productsData,
                navController = navController,
                viewModel = viewModel
            )

        }
    }
}