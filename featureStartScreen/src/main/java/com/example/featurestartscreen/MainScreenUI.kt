package com.example.featurestartscreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.featurestartscreen.uiElements.CategoriesDropdown
import com.example.featurestartscreen.uiElements.SearchBar

val items = listOf(
    "Apple 1", "Banana 2", "Pineapple 3", "Bandage 4", "Aperture 5",
    "Plane 6", "Water 7", "Another string 8", "1119", "123456789"
)

@Composable
fun MainScreenUI(modifier: Modifier = Modifier, navController: NavHostController) {

    var searchValue by remember { mutableStateOf("") }
    var dropdownSearchValue by remember { mutableStateOf("") }
    var chosenCategory by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxSize()
    ) {
        SearchBar(
            searchValue = searchValue,
            onValueChanged = { changedValue -> searchValue = changedValue }
        )
        CategoriesDropdown(
            items = items,
            dropdownSearchValue = dropdownSearchValue,
            onValueChanged = { changedValue ->
                dropdownSearchValue = changedValue
            },
            onCategoryChosen = {
                chosenCategory = it
                Log.d("MyLog", "MainUI: $it")
            }
        )
        Divider(modifier = modifier.padding(all = 14.dp), thickness = 1.dp, color = Color.LightGray)
    }
}