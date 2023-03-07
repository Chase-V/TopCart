package com.example.featureaddproduct

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.coremodel.entities.testCategories
import com.example.coreui.R
import com.example.coreui.elements.CategoriesDropdown
import com.example.coreui.elements.SmallButton
import com.example.featureaddproduct.uiElements.ProductTitleTextField
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreenUI(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var titleValue by rememberSaveable { mutableStateOf("") }
    var dropdownSearchValue by remember { mutableStateOf("") }
    var chosenCategory by remember { mutableStateOf(0L) }
    var commentValue by remember { mutableStateOf("") }
    var photoURI by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf(0F) }
    var barcode by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    //TODO поправить сброс скролла при выборе звезды
    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
            .fillMaxSize()
            .padding(14.dp)
    ) {

        ProductTitleTextField(titleValue = titleValue, onTitleValueChange = { titleValue = it })

        Row {
            CategoriesDropdown(
                items = testCategories,
                dropdownSearchValue = dropdownSearchValue,
                onValueChanged = { dropdownSearchValue = it },
                onCategoryChosen = { chosenCategory = 0L },
                placeholder = stringResource(id = R.string.choose_category),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(com.example.featureaddproduct.R.string.add_category)
                )
            }
        }

        OutlinedTextField(
            value = commentValue,
            onValueChange = { commentValue = it },
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(10.dp),
            maxLines = 4,
            placeholder = { Text(text = stringResource(id = com.example.featureaddproduct.R.string.leave_a_comment)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(vertical = 8.dp)
        ) {
            if (photoURI.isEmpty()) {
                Image(
                    painter = painterResource(id = com.example.featureaddproduct.R.drawable.gallery),
                    contentDescription = stringResource(com.example.featureaddproduct.R.string.product_photo),
                    modifier = modifier
                        .heightIn(min = 150.dp, max = 200.dp)
                        .widthIn(min = 150.dp, max = 250.dp)
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(10.dp)
                        )
                )
            } else {
                AsyncImage(
                    model = photoURI,
                    contentDescription = stringResource(com.example.featureaddproduct.R.string.product_photo),
                    placeholder = painterResource(id = com.example.featureaddproduct.R.drawable.gallery),
                    modifier = modifier
                        .heightIn(min = 150.dp, max = 200.dp)
                        .widthIn(min = 150.dp, max = 250.dp)
                )
            }

            SmallButton(
                iconResId = R.drawable.camera,
                onClick = {
//                TODO() открыть камеру для фото
                },
                modifier = Modifier.padding(start = 8.dp)
            )

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            RatingBar(
                value = rating,
                onValueChange = { rating = it },
                onRatingChanged = {},
                modifier = modifier.align(Alignment.CenterHorizontally),
                config = RatingBarConfig()
                    .stepSize(StepSize.ONE)
                    .style(RatingBarStyle.HighLighted)
                    .size(32.dp)
            )
            Text(text = stringResource(com.example.featureaddproduct.R.string.how_are_you_rate_it))
        }



        OutlinedTextField(
            value = barcode,
            onValueChange = { barcode = it },
            placeholder = { Text(text = stringResource(com.example.featureaddproduct.R.string.barcode)) },
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.barcode_scanner),
                    contentDescription = stringResource(
                        id = R.string.open_barcode_scanner_button
                    ),
                    modifier = Modifier
                        .clickable {
//                            TODO открыть сканер штрихкодов
                        }
                        .size(24.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            )
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            placeholder = { Text(text = stringResource(com.example.featureaddproduct.R.string.price)) },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )

        Button(
            shape = ButtonDefaults.elevatedShape,
            onClick = {
                //TODO кнопка сохранения товара
            },
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp),
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 14.dp)
        ) {
            Text(
                text = stringResource(com.example.featureaddproduct.R.string.save),
                modifier = modifier.padding(14.dp)
            )
        }
    }
}
