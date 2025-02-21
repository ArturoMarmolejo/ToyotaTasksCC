package com.arturomarmolejo.toyotataskscc.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity

@Database(version = 1,
        entities = [TaskEntity::class]
    )
abstract class TasksDatabase(): RoomDatabase() {
    abstract fun taskDao(): TaskDao
}