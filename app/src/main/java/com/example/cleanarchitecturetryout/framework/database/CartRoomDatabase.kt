package com.example.cleanarchitecturetryout.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartEntity::class], version = 1, exportSchema = false)
abstract class CartRoomDatabase: RoomDatabase() {

    abstract fun cartDao(): CartDao

    companion object {
        var dbInstance: CartRoomDatabase? = null
        fun getDbInstance(context: Context): CartRoomDatabase? {
            if (dbInstance == null) {
                synchronized(CartRoomDatabase::class.java) {
                    dbInstance = Room.databaseBuilder(context.applicationContext,
                        CartRoomDatabase::class.java, "cart_database")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return dbInstance
        }
    }
}