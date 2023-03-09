package com.example.datasource.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.datasource.entities.ProductCategoryEntity
import com.example.datasource.entities.ProductEntity
import kotlinx.coroutines.CoroutineScope

@Database(entities = [ProductEntity::class, ProductCategoryEntity::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getRoomDao(): AppRoomDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context, scope: CoroutineScope): AppRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "AppDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}