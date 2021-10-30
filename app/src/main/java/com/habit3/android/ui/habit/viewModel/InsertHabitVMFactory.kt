package com.habit3.android.ui.habit.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InsertHabitVMFactory(private val number: Long) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InsertHabitVM(number) as T
    }
}