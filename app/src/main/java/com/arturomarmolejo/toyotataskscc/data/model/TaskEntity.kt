package com.arturomarmolejo.toyotataskscc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "taskList")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val taskName: String,
    val taskDefinition: String
)
