package com.arturomarmolejo.toyotataskscc.di

import com.arturomarmolejo.toyotataskscc.data.database.TaskDao
import com.arturomarmolejo.toyotataskscc.data.database.TasksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.internal.concurrent.Task

@Module
@InstallIn(SingletonComponent::class)
class TasksModule {

    @Provides
    fun providesCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun providesTaskDao(tasksDatabase: TasksDatabase): TaskDao {
        return tasksDatabase.taskDao()
    }
}