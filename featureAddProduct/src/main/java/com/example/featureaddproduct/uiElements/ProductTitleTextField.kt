package com.example.featureaddproduct.uiElements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.featureaddproduct.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductTitleTextField(
    modifier: Modifier = Modifier,
    titleValue: String,
    onTitleValueChange: (String) -> Unit,
    isReadOnly: Boolean = false
) {

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = titleValue,
        onValueChange = onTitleValueChange,
        readOnly = isReadOnly,
        placeholder = { Text(text = stringResource(R.string.product_title)) },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}