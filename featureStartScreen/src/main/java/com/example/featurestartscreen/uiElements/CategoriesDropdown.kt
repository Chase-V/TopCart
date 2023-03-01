package com.example.featurestartscreen.uiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.featurestartscreen.R

/**
 * При вызове необходимо передать список строк(items) для подсказок при вводе,
 * значение для строки поиска(dropdownSearchValue), обработчик изменений текста
 * в поле ввода (onValueChanged), из которого значение нужно обязательно
 * передать обратно в dropdownSearchValue, и обработку функции onCategoryChosen,
 * которая передает выбранную категорию по клику по элементу из выпадающего списка.
 */

//TODO реализовать обработку изменения фокуса со строки ввода для скрытия списка. + beautify

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesDropdown(
    modifier: Modifier = Modifier,
    items: List<String>,
    dropdownSearchValue: String,
    onValueChanged: (String) -> Unit,
    onCategoryChosen: (String) -> Unit
) {

    var isExpanded by rememberSaveable { mutableStateOf(false) }

    val icon = if (isExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            value = dropdownSearchValue,
            onValueChange = {
                onValueChanged(it)
                isExpanded = true
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = stringResource(R.string.choose_category),
                    modifier
                        .clickable { isExpanded = !isExpanded },
                )
            },
            label = {
                Text(text = stringResource(R.string.choose_category))
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                focusedBorderColor = Color.Transparent,
            ),
        )

        if (isExpanded) {
            LazyColumn(
                modifier = modifier
                    .heightIn(max = 200.dp)
                    .padding(top = 4.dp)
                    .background(
                        MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(10.dp)
                    ),
            ) {
                items(items) { suggestion ->
                    if (suggestion.contains(dropdownSearchValue, true)) {
                        DropdownItem(text = suggestion, modifier = modifier
                            .fillMaxWidth()
                            .clickable {
                                onValueChanged(suggestion)
                                onCategoryChosen(suggestion)
                                isExpanded = false
                            })
                    }
                }
            }
        }
    }
}

@Composable
fun DropdownItem(modifier: Modifier = Modifier, text: String) {
    Text(text = text, modifier = modifier.padding(horizontal = 14.dp, vertical = 8.dp))
}
