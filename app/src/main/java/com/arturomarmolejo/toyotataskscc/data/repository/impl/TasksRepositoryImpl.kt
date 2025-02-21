package com.arturomarmolejo.toyotataskscc.data.repository.impl

import com.arturomarmolejo.toyotataskscc.core.UIState
import com.arturomarmolejo.toyotataskscc.data.database.TaskDao
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity
import com.arturomarmolejo.toyotataskscc.data.repository.TaskRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TasksRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao,
    private val coroutineDispatcher: CoroutineDispatcher
): TaskRepository {
    override suspend fun getAllTasks(): Flow<UIState<List<TaskEntity>>> = flow {
        emit(UIState.LOADING)
        try {
            emit(UIState.SUCCESS(taskDao.getAllTasks()))
        } catch (e: Exception) {
            emit(UIState.ERROR(e.message.toString()))
        }
    }.flowOn(coroutineDispatcher)

    override suspend fun insertTask(task: TaskEntity) {
        taskDao.insertTask(task)
    }
}