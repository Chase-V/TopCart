package com.example.coremodel.entities

import java.util.Date

data class Product(
    val productId: Long,
    val categoryID: Long,
    val title: String,
    val comment: String,
    val rating: Int,
    val photoURI: String? = null,
    val barcode: Long? = null,
    val price: Float? = null,
    val createdAt: Date? = null
)

//TODO убрать тестовый список товаров
val testProducts = listOf(
    Product(
        productId = 122L,
        categoryID = 1,
        title = "Какое-то кино с очень длинным названием ради того, чтобы посмотреть на название карточки в несколько строк",
        comment = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.",
        rating = 4,
        photoURI = "https://picsum.photos/1921/1081",
        barcode = null,
    ),
    Product(
        productId = 123L,
        categoryID = 2,
        title = "TOPOVOE JIJLO",
        comment = "vkoosno, но Душа моя озарена неземной радостью, как эти чудесные весенние утра, которыми я наслаждаюсь от всего сердца. Я совсем один и блаженствую в здешнем краю, словно созданном для таких, как я. Я так счастлив, мой друг, так упоен ощущением покоя, что искусство мое страдает от этого. Ни одного штриха не мог бы я сделать, а никогда не был таким большим художником, как в эти минуты. Когда от милой моей долины поднимается пар и полдневное солнце стоит над непроницаемой чащей темного леса и лишь редкий луч проскальзывает в его святая святых, а я лежу в высокой траве",
        rating = 3,
        photoURI = null,
        barcode = 228228228,
        price = 228.99f
    ),
    Product(
        productId = 124L,
        categoryID = 3,
        title = "Азерчай с бергамотом",
        comment = "Это вкусно, но не то чтобы по вкусу вкусно, но по сути вкусно!",
        rating = 4,
        photoURI = "https://picsum.photos/1920/1080",
        barcode = null,
    ),
    Product(
        productId = 125L,
        categoryID = 0,
        title = "Артемов Олег Егорович",
        comment = "Было больно, вырвал 2 лишних передних зуба",
        rating = 2,
        barcode = null,
    ),
    Product(
        productId = 124L,
        categoryID = 4,
        title = "Какое-то кинцо 2",
        comment = "Первая часть была лучше, но тот тип все вытащил на себе",
        rating = 4,
        photoURI = null,
        barcode = null,
    ),
    Product(
        productId = 126L,
        categoryID = 5,
        title = "Джин Gordon's",
        comment = "Кайф, с тоником самое то",
        rating = 5,
        photoURI = null,
        barcode = null,
    ),
    Product(
        productId = 122L,
        categoryID = 1,
        title = "Какое-то кино с очень длинным названием ради того, чтобы посмотреть на название карточки в несколько строк",
        comment = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.",
        rating = 4,
        photoURI = "https://picsum.photos/1921/1081",
        barcode = null,
    ),
    Product(
        productId = 123L,
        categoryID = 2,
        title = "TOPOVOE JIJLO",
        comment = "vkoosno, но Душа моя озарена неземной радостью, как эти чудесные весенние утра, которыми я наслаждаюсь от всего сердца. Я совсем один и блаженствую в здешнем краю, словно созданном для таких, как я. Я так счастлив, мой друг, так упоен ощущением покоя, что искусство мое страдает от этого. Ни одного штриха не мог бы я сделать, а никогда не был таким большим художником, как в эти минуты. Когда от милой моей долины поднимается пар и полдневное солнце стоит над непроницаемой чащей темного леса и лишь редкий луч проскальзывает в его святая святых, а я лежу в высокой траве",
        rating = 3,
        photoURI = null,
        barcode = 228228228,
        price = 228.99f
    ),
    Product(
        productId = 124L,
        categoryID = 3,
        title = "Азерчай с бергамотом",
        comment = "Это вкусно, но не то чтобы по вкусу вкусно, но по сути вкусно!",
        rating = 4,
        photoURI = "https://picsum.photos/1920/1080",
        barcode = null,
    ),
    Product(
        productId = 125L,
        categoryID = 0,
        title = "Артемов Олег Егорович",
        comment = "Было больно, вырвал 2 лишних передних зуба",
        rating = 2,
        barcode = null,
    ),
    Product(
        productId = 124L,
        categoryID = 4,
        title = "Какое-то кинцо 2",
        comment = "Первая часть была лучше, но тот тип все вытащил на себе",
        rating = 4,
        photoURI = null,
        barcode = null,
    ),
    Product(
        productId = 126L,
        categoryID = 5,
        title = "Джин Gordon's",
        comment = "Кайф, с тоником самое то",
        rating = 5,
        photoURI = null,
        barcode = null,
    ),
)