package com.example.featurestartscreen.uiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
    onValueChanged: (String) -> Unit,
    onBarcodeButtonPressed:()->Unit
) {
    BasicTextField(
        value = searchValue,
        onValueChange = onValueChanged,
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(horizontal = 14.dp, vertical = 4.dp)
            .fillMaxHeight(),
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        ),

        decorationBox = { innerTextField ->
            Row(modifier, verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = modifier.weight(1f)) {
                    if (searchValue.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.search_bar_placeholder),
                            style = LocalTextStyle.current.copy(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                            )

                        )
                    }
                    innerTextField()
                }
                Icon(
                    painter = painterResource(id = com.example.coreui.R.drawable.barcode_scanner),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable(onClick = onBarcodeButtonPressed),
                    tint = Color(MaterialTheme.colorScheme.onPrimaryContainer.value)
                )
            }
        }
    )
}