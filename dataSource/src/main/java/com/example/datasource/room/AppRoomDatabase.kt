package com.example.datasource.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coremodel.entities.Product
import com.example.coremodel.entities.ProductCategory

@Database(entities = [Product::class, ProductCategory::class], version = 1)
abstract class AppRoomDatabase :RoomDatabase() {

    abstract fun getRoomDao():AppRoomDao

    companion object{

        @Volatile
        private var INSTANCE:AppRoomDatabase? = null

        fun getInstance(context:Context):AppRoomDatabase{
            return if (INSTANCE==null){
                INSTANCE = Room.databaseBuilder(context, AppRoomDatabase::class.java, "AppDatabase").build()
                INSTANCE as AppRoomDatabase
            } else{
                INSTANCE as AppRoomDatabase
            }
        }

    }
}