package service

import model.Task

class TaskService {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    fun addTask(title: String): Task {
        val newTask = Task(id = nextId++, title = title)
        tasks.add(newTask)
        return newTask
    }
    fun getAllTasks(): List<Task> {
        return tasks
    }
    fun completeTask(id: Int): Boolean {
        val index = tasks.indexOfFirst { it.id == id }
        if (index == -1) return false

        val task = tasks[index]
        tasks[index] = task.copy(isCompleted = true)
        return true
    }
    fun printTasks(tasks: List<model.Task>) {
        if (tasks.isEmpty()) {
            println("No tasks available.")
            return
        }
        tasks.forEach { task ->
            println("ID: ${task.id}, Title: ${task.title}, Completed?: ${task.isCompleted}") 
        }

    }
}