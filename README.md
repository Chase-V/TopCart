# TopCart

Приложение разрабатывается в первую очередь для практики работы с многомодульностью, Compose, Coroutines и Flow и работы с камерой.

Основная задумка приложения заключается в возможности для себя удобно оценить все, что задумается и также удобно сгруппировать и рассортировать все это. Сейчас существует огромное количество товаров и услуг и довольно легко забыть своё впечатление от них, поэтому мне и пришла идея реализовать такой проект.

Приложение находится на ранней стадии разработки и еще далек до завершения. Базовый функционал уже частично реализован, но еще не оттестирован и "отполирован" и вероятно будет еще неоднократно переписываться по ходу нарабатывания опыта и улучшения навыков.

Архитектура MVVM. 
Построение интерфейса осуществляется с помощью библиотеки Jetpack Compose.
Для асинхронных задач используется Kotlin Coroutines и Flow.
Для работы с камерой используется библиотека CameraX и Camera2.
Для сканера штрих-кодов используется библиотека MLKit.
Для DI используется Koin.

Собственный макет дизайна:

![Start screen main](https://github.com/Chase-V/TopCart/assets/38985553/726ccb84-5a0d-4ed5-8c69-23f57f03caee)
![Start screen main2](https://github.com/Chase-V/TopCart/assets/38985553/d618b4ee-5e10-4e45-a6e2-4c4cbfa4f971)
![Start screen main3](https://github.com/Chase-V/TopCart/assets/38985553/0670cda9-5ac2-4d2d-a061-5e68c1888c2f)


Figma: https://www.figma.com/file/O9f6aPaltcWLbNbo7K3yrc/Untitled?node-id=0%3A1&t=mOYO9nLg1HrGrcNb-1

