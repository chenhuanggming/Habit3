package com.habit3.android.ui.habit.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class InsertHabitVM(number: Long) : ViewModel(){

    var title = ""
    var deadline = ""
    var residue = 0
    var insertJudge = MutableLiveData<Long>()

    init {
        insertJudge.value = number
    }


}