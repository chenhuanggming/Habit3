package com.habit3.android.ui.habit.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.habit3.android.logic.Repository
import com.habit3.android.logic.model.WishBean

class HabitViewModel : ViewModel() {

    private val loadAllLiveData = MutableLiveData<Any?>()

    val habitList = ArrayList<WishBean>()

    val loadAllResult = Transformations.switchMap(loadAllLiveData){
        Log.d("zhixing","${Thread.currentThread()}")
        Repository.loadAllHabits()
    }

    fun loadAllHabits(){
        loadAllLiveData.value = loadAllLiveData.value
    }

}