package com.arturomarmolejo.toyotataskscc.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity

/**
 * [TaskDao] Data Access Object for [TaskEntity] table. Provides methods for
 * interacting with the database using Room through the [TaskRepository].
 */
@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM taskList")
    suspend fun getAllTasks(): List<TaskEntity>

    @Query("SELECT * FROM taskList where taskName LIKE :taskName")
    suspend fun getTasksByName(taskName: String): List<TaskEntity>
}