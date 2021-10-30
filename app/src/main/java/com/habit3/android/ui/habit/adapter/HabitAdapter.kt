package com.habit3.android.ui.habit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.habit3.android.R
import com.habit3.android.logic.model.WishBean

class HabitAdapter(private val fragment: Fragment, private val habitList: List<WishBean>) :
    RecyclerView.Adapter<HabitAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wishName: TextView = view.findViewById(R.id.wishName)
        val residue: TextView = view.findViewById(R.id.residue)
        val percentage: TextView = view.findViewById(R.id.percentage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.habit_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val habit = habitList[position]
        holder.wishName.text = habit.wish_name
        holder.residue.text = habit.residue.toString()
        holder.percentage.text = (habit.now_grade/habit.total_grade).toString()
    }

    override fun getItemCount() =habitList.size
}