package com.habit3.android.logic.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WishBean(val wish_name: String, val now_grade: Int,
                    val total_grade: Int,val wish_date: String,val residue: Int ){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}


data class TaskBean(val task_name: String,val task_content: String,
        val task_grade: Int,val task_state: String,val task_type: Int)




