package com.habit3.android.ui.habit.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.habit3.android.BaseActivity
import com.habit3.android.R
import com.habit3.android.logic.Repository
import com.habit3.android.logic.model.WishBean
import com.habit3.android.ui.habit.viewModel.InsertHabitVM
import com.habit3.android.ui.habit.viewModel.InsertHabitVMFactory
import kotlin.concurrent.thread

class InsertHabit : BaseActivity() {

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context, InsertHabit::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_habit)

    }
}