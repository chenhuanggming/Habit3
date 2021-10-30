package com.habit3.android.ui.habit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.habit3.android.R
import com.habit3.android.logic.Repository
import com.habit3.android.logic.model.WishBean
import com.habit3.android.ui.habit.viewModel.InsertHabitVM
import com.habit3.android.ui.habit.viewModel.InsertHabitVMFactory
import kotlin.concurrent.thread

class InsertHabitFragment : Fragment() {

    lateinit var title: EditText
    lateinit var deadline: EditText
    lateinit var residue: EditText
    lateinit var confirm: Button

    lateinit var viewModel: InsertHabitVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_insert_habit,container,false)
        title = view.findViewById(R.id.title)
        deadline = view.findViewById(R.id.deadline)
        residue = view.findViewById(R.id.residue)
        confirm = view.findViewById(R.id.confirm_button)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, InsertHabitVMFactory(-1)).get(InsertHabitVM::class.java)

        confirm.setOnClickListener {
            viewModel.let {
                it.title = title.text.toString()
                it.deadline = deadline.text.toString()
                it.residue = residue.text.toString().toInt()
                if(it.title.isNotEmpty()&&it.deadline.isNotEmpty()
                    &&it.residue > 0){
                    val habit = WishBean(it.title,1,1,
                        it.deadline, it.residue)
                    thread {
                        it.insertJudge.postValue(Repository.insertHabit(habit))
                    }
                }
            }

        }

        viewModel.insertJudge.observe(this) {
            if(it != -1L){
                activity?.finish()
            }
        }
    }
}