package com.habit3.android.logic.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.habit3.android.logic.model.WishBean

@Dao
interface HabitDao {

    @Insert
    fun insertHabit(habit: WishBean): Long

    @Update
    fun updateHabit(newHabit: WishBean)

    @Query("select * from WishBean")
    fun loadAllHabits(): LiveData<List<WishBean>>

    @Delete
    fun deleteUser(habit: WishBean)


}