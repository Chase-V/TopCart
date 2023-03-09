package com.example.featurestartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coremodel.entities.testCategories
import com.example.coremodel.entities.testProducts
import com.example.coreui.elements.CategoriesDropdown
import com.example.coreui.elements.SmallButton
import com.example.featurestartscreen.uiElements.ProductList
import com.example.featurestartscreen.uiElements.SearchBar

@Composable
fun MainScreenUI(modifier: Modifier = Modifier, navController: NavHostController) {

    var searchValue by remember { mutableStateOf("") }
    var dropdownSearchValue by remember { mutableStateOf("") }
    var chosenCategory by remember { mutableStateOf(0L) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 14.dp, end = 14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            SearchBar(
                searchValue = searchValue,
                modifier = modifier.height(54.dp),
                onValueChanged = { changedValue -> searchValue = changedValue }
            )

            SmallButton(iconResId = com.example.coreui.R.drawable.barcode_scanner, onClick = {
//                TODO кнопка для сканера
            })
        }

        CategoriesDropdown(
            items = testCategories,
            dropdownSearchValue = dropdownSearchValue,
            onValueChanged = { changedValue ->
                dropdownSearchValue = changedValue
            },
            onCategoryChosen = {
                chosenCategory = it
            },
            placeholder = stringResource(id = R.string.choose_category)
        )
        Divider(modifier = modifier.padding(all = 14.dp), thickness = 1.dp, color = Color.LightGray)

        //TODO убрать фильтр, это для теста
        ProductList(
            products = if (chosenCategory == 0.toLong()) testProducts
            else testProducts.filter { it.categoryID.categoryId == chosenCategory }
        )

    }
}