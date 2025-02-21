package com.arturomarmolejo.toyotataskscc.data.repository

import com.arturomarmolejo.toyotataskscc.core.UIState
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import okhttp3.internal.concurrent.Task

interface TaskRepository {
    suspend fun insertTask(task: TaskEntity)
    suspend fun getAllTasks(): Flow<UIState<List<TaskEntity>>>
}