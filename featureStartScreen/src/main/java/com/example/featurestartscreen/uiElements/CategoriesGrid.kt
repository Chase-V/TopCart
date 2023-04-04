package com.example.featurestartscreen.uiElements

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.coremodel.entities.ProductCategory
import com.example.sharedviewmodel.SharedViewModel

@Composable
fun CategoriesGrid(
    modifier: Modifier = Modifier,
    categoriesList: List<ProductCategory>,
    viewModel: SharedViewModel
//    onCategoryClick: () -> Unit,
//    onCategoryLongClick: () -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(categoriesList) { category ->

            CategoriesGridItem(
                category = category,
                onCategoryClick = {
                    viewModel.categoriesChanged(category)
                },
                onCategoryLongClick = {
                    viewModel.deleteCategory(category)
                }
            )

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoriesGridItem(
    modifier: Modifier = Modifier,
    category: ProductCategory,
    onCategoryClick: () -> Unit,
    onCategoryLongClick: () -> Unit
) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = modifier
            .aspectRatio(1f),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Box(
            modifier.combinedClickable(
                onClick = onCategoryClick,
                onLongClick = onCategoryLongClick,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(bounded = true)
            )
        ) {
            Text(
                text = category.categoryTitle,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentHeight(),
                overflow = TextOverflow.Ellipsis,
            )
        }

    }

}