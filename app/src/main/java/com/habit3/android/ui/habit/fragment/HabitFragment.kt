package com.habit3.android.ui.habit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.habit3.android.HabitApplication
import com.habit3.android.R
import com.habit3.android.ui.habit.adapter.HabitAdapter
import com.habit3.android.ui.habit.viewModel.HabitViewModel
import com.habit3.android.ui.habit.activity.InsertHabit

class HabitFragment : Fragment() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(HabitViewModel::class.java) }
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HabitAdapter
    private lateinit var searchHabitEdit: EditText
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_habit,container,false)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchHabitEdit = view.findViewById(R.id.searchHabitEdit)
        floatingActionButton = view.findViewById(R.id.fab)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loadAllHabits()
        //习惯列表
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        adapter = HabitAdapter(this,viewModel.habitList)
        recyclerView.adapter = adapter
        //添加计划
        floatingActionButton.setOnClickListener {
            InsertHabit.actionStart(HabitApplication.context)
        }
        //观察计划的变化
        viewModel.loadAllResult.observe(this,{ result ->
            if (result != null) {
                viewModel.habitList.clear()
                viewModel.habitList.addAll(result.reversed())
                adapter.notifyItemInserted(0)
            }else{
                Toast.makeText(activity,"no data",Toast.LENGTH_SHORT).show()
            }

        })
    }
}