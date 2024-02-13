package com.example.featureaddproduct

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory
import com.example.coremodel.entities.emptyCategory
import com.example.coreui.elements.CategoriesDropdown
import com.example.coreui.elements.SmallButton
import com.example.featureaddproduct.uiElements.ProductTitleTextField
import com.example.sharedviewmodel.SharedViewModel
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize
import org.koin.androidx.compose.koinViewModel
import java.util.Date


@Composable
fun EditProductScreenUI(
    modifier: Modifier = Modifier,
    productId: Long,
    navController: NavController
) {
    val viewModel = koinViewModel<SharedViewModel>()
    val product by viewModel.getProduct(productId).collectAsState(initial = null)
    val allCategoriesList by viewModel.suggestedCategories.collectAsState(initial = listOf())


    if (product == null) {
        CircularProgressIndicator(modifier = modifier.fillMaxSize())
    } else {
        Log.d("MyLog", "EditProductScreenUI: product:$product")
        Log.d("MyLog", "EditProductScreenUI: cats:$allCategoriesList")
        EditProduct(
            product = product!!,
            allCategoriesList = allCategoriesList,
            viewModel = viewModel,
            onProductChanged = {
                navController.popBackStack()
            })
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProduct(
    product: Product,
    allCategoriesList: List<ProductCategory>,
    modifier: Modifier = Modifier,
    viewModel: SharedViewModel,
    onProductChanged: () -> Unit
) {
    var titleValue by rememberSaveable { mutableStateOf(product.title) }
    var commentValue by rememberSaveable { mutableStateOf(product.comment) }
    var rating by rememberSaveable { mutableStateOf(product.rating) }
    var barcode by rememberSaveable {
        mutableStateOf(
            if (product.barcode == null) ""
            else product.barcode.toString()
        )
    }
    var price by rememberSaveable {
        mutableStateOf(
            if (product.price == null) ""
            else product.price.toString()
        )
    }
    var photoURI by rememberSaveable { mutableStateOf(product.photoURI) }
    var currentCategory by remember {
        mutableStateOf(
            if (allCategoriesList.isNullOrEmpty()) emptyCategory()
            else allCategoriesList.first {
                Log.d("MyLog", "allCategoriesList.first: $it")
                Log.d("MyLog", "EditProductScreenUI: it.categoryId:${it.categoryId}")
                Log.d("MyLog", "EditProductScreenUI: product.categoryID:${product.categoryID}")
                it.categoryId == product.categoryID
            }
        )
    }
    var dropdownSearchValue by rememberSaveable { mutableStateOf(currentCategory.categoryTitle) }

    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
            .fillMaxSize()
            .padding(14.dp)
    ) {

        ProductTitleTextField(
            titleValue = titleValue,
            onTitleValueChange = { titleValue = it }
        )
        Row {
            CategoriesDropdown(
                items = allCategoriesList ?: listOf(),
                dropdownSearchValue = dropdownSearchValue,
                onValueChanged = {
                    dropdownSearchValue = it
                },
                onCategoryChosen = {
                    currentCategory = it
                    dropdownSearchValue = it.categoryTitle
                },
                placeholder = stringResource(id = com.example.coreui.R.string.choose_category),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(R.string.add_category)
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
            placeholder = { Text(text = stringResource(id = R.string.leave_a_comment)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
        ) {
            if (photoURI.isNullOrEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.gallery),
                    contentDescription = stringResource(R.string.product_photo),
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
                    contentDescription = stringResource(R.string.product_photo),
                    placeholder = painterResource(id = R.drawable.gallery),
                    modifier = modifier
                        .heightIn(min = 150.dp, max = 200.dp)
                        .widthIn(min = 150.dp, max = 250.dp)
                )
            }

            SmallButton(
                iconResId = com.example.coreui.R.drawable.camera,
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
                value = rating.toFloat(),
                onValueChange = { rating = it.toInt() },
                onRatingChanged = {},
                modifier = modifier.align(Alignment.CenterHorizontally),
                config = RatingBarConfig()
                    .stepSize(StepSize.ONE)
                    .style(RatingBarStyle.HighLighted)
                    .size(32.dp)
            )
            Text(text = stringResource(R.string.how_are_you_rate_it))
        }



        OutlinedTextField(
            value = barcode,
            onValueChange = {
                barcode = if (it.isEmpty()) {
                    it
                } else {
                    when (it.toIntOrNull()) {
                        null -> barcode //old value
                        else -> it   //new value
                    }
                }
            },
            placeholder = { Text(text = stringResource(R.string.barcode)) },
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = com.example.coreui.R.drawable.barcode_scanner),
                    contentDescription = stringResource(
                        id = com.example.coreui.R.string.open_barcode_scanner_button
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
            onValueChange = {
                price = if (it.isEmpty()) {
                    it
                } else {
                    when (it.toDoubleOrNull()) {
                        null -> price //old value
                        else -> it   //new value
                    }
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            placeholder = { Text(text = stringResource(R.string.price)) },
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
                val edited = Product(
                    productId = product.productId,
                    categoryID = currentCategory.categoryId,
                    title = titleValue,
                    comment = commentValue,
                    rating = rating,
                    photoURI = photoURI,
                    barcode = barcode,
                    price = price,
                    createdAt = Date()
                )
                viewModel.updateProduct(
                    edited
                )
                onProductChanged()

            },
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp),
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 14.dp)
        ) {
            Text(
                text = stringResource(R.string.save),
                modifier = modifier.padding(14.dp)
            )
        }


    }
}