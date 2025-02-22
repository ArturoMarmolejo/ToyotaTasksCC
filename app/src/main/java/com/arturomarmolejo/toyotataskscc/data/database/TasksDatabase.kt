package com.arturomarmolejo.toyotataskscc.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity


/**
 * [TasksDatabase] Room Database for the app. It is composed of the [TaskEntity] and [TaskDao].
 */
@Database(version = 1,
        entities = [TaskEntity::class]
    )
abstract class TasksDatabase(): RoomDatabase() {
    abstract fun taskDao(): TaskDao
}