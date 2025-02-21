package com.arturomarmolejo.toyotataskscc.di

import com.arturomarmolejo.toyotataskscc.data.repository.TaskRepository
import com.arturomarmolejo.toyotataskscc.data.repository.impl.TasksRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class TasksRepository {

    @Binds
    abstract fun bindsTaskRepository(taskRepositoryImpl: TasksRepositoryImpl): TaskRepository
}