package com.example.featurestartscreen.uiElements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.featurestartscreen.R

/**
 * При вызове необходимо передать значение для поля поиска
 * и реализовать обработку его изменения пользователем,
 * при этом обязательно изменения передавать в searchValue,
 * иначе визуально значение в строке не будет меняться.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchValue: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = searchValue,
        onValueChange = onValueChanged,
        shape = RoundedCornerShape(100),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(R.string.search_button_description)
            )
        },
        singleLine = true,
        placeholder = {
            Text(text = stringResource(R.string.search_bar_placeholder))
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
//            focusedBorderColor = Color.Transparent
        )
    )
}