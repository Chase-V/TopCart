package com.example.featureaddproduct

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.coremodel.entities.ProductCategory
import com.example.coremodel.entities.emptyCategory
import com.example.coremodel.tools.AppNavRoute
import com.example.coreui.elements.CategoriesDropdown
import com.example.featureaddproduct.uiElements.ProductTitleTextField
import com.example.sharedviewmodel.SharedViewModel
import org.koin.androidx.compose.koinViewModel
import java.util.Date

@Composable
fun AddCategoryScreenUI(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    var viewModel = koinViewModel<SharedViewModel>()

    var title by rememberSaveable {
        mutableStateOf("")
    }

    var categoriesTextFieldValue by rememberSaveable {
        mutableStateOf("")
    }

    var chosenCategory by remember {
        mutableStateOf(emptyCategory())
    }

    val categoriesList by viewModel.getAllCategories.collectAsState(initial = emptyList())

    Column(modifier = modifier.fillMaxWidth()) {
        ProductTitleTextField(titleValue = title, onTitleValueChange = { title = it })
        CategoriesDropdown(
            items = categoriesList,
            dropdownSearchValue = categoriesTextFieldValue,
            onValueChanged = { categoriesTextFieldValue = it },
            onCategoryChosen = { chosenCategory = it },
            placeholder = stringResource(R.string.chose_parent_category)
        )
        Button(onClick = {

            val category = ProductCategory(
                categoryTitle = title,
                parentCategoryId = chosenCategory.categoryId,
                createdAt = Date()
            )

            viewModel.addCategory(
                category
            ) {}
            Log.d("MyLog", "AddCategoryScreenUI: successfully added: $category ")
            navController.popBackStack()
        }) {
            Text(text = stringResource(id = R.string.save))
        }
    }
}