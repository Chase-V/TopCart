package com.example.topcart.di

import androidx.room.Room
import com.example.coremodel.repository.Repository
import com.example.datasource.repoImpl.RepositoryImpl
import com.example.datasource.room.AppRoomDao
import com.example.datasource.room.AppRoomDatabase
import com.example.sharedviewmodel.SharedViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<AppRoomDatabase> {
        Room.databaseBuilder(
            androidApplication(),
            AppRoomDatabase::class.java,
            "app_room_database"
            ).build()
    }

    single<AppRoomDao> {
        val database = get<AppRoomDatabase>()
        database.getRoomDao()
    }

    single<Repository> { RepositoryImpl(get<AppRoomDao>()) }

    viewModel<SharedViewModel> { SharedViewModel(get<Repository>()) }
}