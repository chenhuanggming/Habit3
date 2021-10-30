package com.habit3.android.logic

import androidx.lifecycle.LiveData
import com.habit3.android.HabitApplication
import com.habit3.android.logic.dao.HabitDao
import com.habit3.android.logic.database.AppDatabase
import com.habit3.android.logic.model.WishBean

object Repository {

    private var appDatabase: AppDatabase = AppDatabase.getDatabase(HabitApplication.context)

    fun insertHabit(habit: WishBean): Long{
        return appDatabase.habitDao().insertHabit(habit)
    }

    fun updateHabit(newHabit: WishBean){
        appDatabase.habitDao().updateHabit(newHabit)
    }

    fun loadAllHabits(): LiveData<List<WishBean>> {
        return appDatabase.habitDao().loadAllHabits()
    }

    fun deleteUser(habit: WishBean){
        appDatabase.habitDao().deleteUser(habit)
    }
}