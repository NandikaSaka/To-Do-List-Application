package com.example.todolisttutorial

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TaskItemRepository(private val taskItemDao: TaskItemDao)
{
    val allTaskItems: Flow<List<TaskItem>> = taskItemDao.allTaskItems()

    @WorkerThread
    suspend fun insertTaskItem(taskItem: TaskItem)
    {
        taskItemDao.insertTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun updateTaskItem(taskItem: TaskItem)
    {
        taskItemDao.updateTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun deleteTaskItem(taskItem: TaskItem){
        taskItemDao.deleteTaskItem(taskItem)
    }

    fun searchTaskItems(query: String): Flow<List<TaskItem>> {
        return taskItemDao.searchTaskItems("%$query%")
    }
}