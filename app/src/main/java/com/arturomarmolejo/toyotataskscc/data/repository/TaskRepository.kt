package com.arturomarmolejo.toyotataskscc.data.repository

import com.arturomarmolejo.toyotataskscc.core.UIState
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow

/**
 * [TaskRepository] repository that retrieves and inserts data into the local database through the use
 * of the [getAllTasks] and [insertTask] methods, respectively. Notice the [getAllTasks] method
 * returns a Flow containing a [UIState], which can contain the list of data from the database if
 * it is successful.
 */
interface TaskRepository {
    suspend fun insertTask(task: TaskEntity)
    suspend fun getAllTasks(): Flow<UIState<List<TaskEntity>>>
}