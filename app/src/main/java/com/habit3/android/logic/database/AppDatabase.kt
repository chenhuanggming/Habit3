package com.habit3.android.logic.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.habit3.android.logic.dao.HabitDao
import com.habit3.android.logic.model.WishBean

@Database(version = 1,entities = [WishBean::class])
abstract class AppDatabase : RoomDatabase(){

    abstract fun habitDao(): HabitDao

    companion object{

        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase{
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,"app_database")
//                .allowMainThreadQueries()
                .build().apply {
                    instance = this
                }
        }
    }

}