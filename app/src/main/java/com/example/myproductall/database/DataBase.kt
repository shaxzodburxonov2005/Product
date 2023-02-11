package com.example.myproductall.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myproductall.`interface`.ProductDao
import com.example.myproductall.product.Product
import com.example.myproductall.product.Tayp
import com.example.myproductall.product.User

@Database(entities = [Product::class, Tayp::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun userDao(): ProductDao

    companion object {
        private var instance: DataBase? = null

        @Synchronized
        fun getInstance(context: Context): DataBase {
            if (instance == null)
                instance = Room
                    .databaseBuilder(context, DataBase::class.java, "userDb")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            return instance!!
        }
    }

}