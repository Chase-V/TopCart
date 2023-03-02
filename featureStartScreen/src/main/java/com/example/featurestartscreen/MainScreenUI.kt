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
import com.example.featurestartscreen.uiElements.ProductList
import com.example.featurestartscreen.uiElements.SearchBar
import com.example.topcart.core.entities.Product
import com.example.topcart.core.entities.ProductCategory

@Composable
fun MainScreenUI(modifier: Modifier = Modifier, navController: NavHostController) {

    var searchValue by remember { mutableStateOf("") }
    var dropdownSearchValue by remember { mutableStateOf("") }
    var chosenCategory by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 14.dp, end = 14.dp)
    ) {
        SearchBar(
            modifier = modifier.padding(top = 14.dp),
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

        ProductList(products = products)
    }
}

val items = listOf(
    "Apple 1", "Banana 2", "Pineapple 3", "Bandage 4", "Aperture 5",
    "Plane 6", "Water 7", "Another string 8", "1119", "123456789"
)

val products = listOf(
    Product(
        id = 122L,
        category = ProductCategory(id = 10001L, "Кино"),
        title = "Какое-то кино с очень длинным названием ради того, чтобы посмотреть на название карточки в несколько строк",
        comment = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.",
        rating = 4,
        photoURI = "https://picsum.photos/1921/1081",
        barcode = null,
    ),
    Product(
        id = 123L,
        category = ProductCategory(id = 10002L, "Жижа"),
        title = "TOPOVOE JIJLO",
        comment = "vkoosno, но Душа моя озарена неземной радостью, как эти чудесные весенние утра, которыми я наслаждаюсь от всего сердца. Я совсем один и блаженствую в здешнем краю, словно созданном для таких, как я. Я так счастлив, мой друг, так упоен ощущением покоя, что искусство мое страдает от этого. Ни одного штриха не мог бы я сделать, а никогда не был таким большим художником, как в эти минуты. Когда от милой моей долины поднимается пар и полдневное солнце стоит над непроницаемой чащей темного леса и лишь редкий луч проскальзывает в его святая святых, а я лежу в высокой траве",
        rating = 3,
        photoURI = null,
        barcode = 228228228,
        price = 228.99f
    ),
    Product(
        id = 124L,
        category = ProductCategory(id = 10003L, "Чай"),
        title = "Азерчай с бергамотом",
        comment = "Это вкусно, но не то чтобы по вкусу вкусно, но по сути вкусно!",
        rating = 4,
        photoURI = "https://picsum.photos/1920/1080",
        barcode = null,
    ),
    Product(
        id = 125L,
        category = ProductCategory(id = 10001L, "Зубник"),
        title = "Артемов Олег Егорович",
        comment = "Было больно, вырвал 2 лишних передних зуба",
        rating = 2,
        barcode = null,
    ),
    Product(
        id = 124L,
        category = ProductCategory(id = 10001L, "Кино"),
        title = "Какое-то кинцо 2",
        comment = "Первая часть была лучше, но тот тип все вытащил на себе",
        rating = 4,
        photoURI = null,
        barcode = null,
    ),
    Product(
        id = 126L,
        category = ProductCategory(id = 10001L, "Алкоголь"),
        title = "Джин Gordon's",
        comment = "Кайф, с тоником самое то",
        rating = 5,
        photoURI = null,
        barcode = null,
    ),
    Product(
        id = 122L,
        category = ProductCategory(id = 10001L, "Кино"),
        title = "Какое-то кинцо",
        comment = "Not good, but not terrible",
        rating = 4,
        photoURI = null,
        barcode = null,
    ),
    Product(
        id = 123L,
        category = ProductCategory(id = 10002L, "Жижа"),
        title = "TOPOVOE JIJLO",
        comment = "vkoosno",
        rating = 3,
        photoURI = null,
        barcode = 228228228,
        price = 228.99f
    ),
    Product(
        id = 124L,
        category = ProductCategory(id = 10003L, "Чай"),
        title = "Lipton с катышками",
        comment = "Это вкусно, но не то чтобы по вкусу вкусно, но по сути вкусно!",
        rating = 4,
        photoURI = null,
        barcode = null,
    ),
    Product(
        id = 125L,
        category = ProductCategory(id = 10001L, "Зубник"),
        title = "Артемов Олег Егорович",
        comment = "Было больно, вырвал 2 лишних передних зуба, урод",
        rating = 2,
        photoURI = null,
        barcode = null,
    ),
    Product(
        id = 124L,
        category = ProductCategory(id = 10001L, "Кино"),
        title = "Какое-то кинцо 2",
        comment = "Первая часть была лучше, но тот тип все вытащил на себе",
        rating = 4,
        photoURI = null,
        barcode = null,
    ),
    Product(
        id = 126L,
        category = ProductCategory(id = 10001L, "Алкоголь"),
        title = "Джин Gordon's",
        comment = "Кайф, с тоником самое то",
        rating = 5,
        photoURI = null,
        barcode = null,
    ),
)