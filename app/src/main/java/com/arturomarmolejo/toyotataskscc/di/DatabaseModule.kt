package com.arturomarmolejo.toyotataskscc.di

import android.content.Context
import androidx.room.Room
import com.arturomarmolejo.toyotataskscc.data.database.TasksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ): TasksDatabase = Room.databaseBuilder(
        context, TasksDatabase::class.java, "tasks_database"
    ).build()
}