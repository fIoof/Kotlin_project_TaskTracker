
import service.TaskService

fun main() {
    val taskService = service.TaskService()
    println("Welcome to the Task Tracker!")

    while (true) {
        println(
            """
            1. Add Task
            2. View All Tasks
            3. Complete Task
            4. Exit
            """
        )
        println("Choose an Option: ")
        when (readLine()?.trim()) {
            "1" -> {
                println("Enter Task name: ")
                val title = readLine()?.trim() ?: ""
                if(!title.isNullOrEmpty()) {
                    val task = taskService.addTask(title)
                    println("Task Added: $task")
                } else {
                    println("Task title cannot be empty.")
                }
            }
            "2" -> {
                val tasks = taskService.printTasks(taskService.getAllTasks())
                println(tasks)
            }
            "3" -> {
                println("Enter Task ID: ")
                val id = readLine()?.trim()
                    ?.toIntOrNull()
                if (id != null) {
                    val success = taskService.completeTask(id)
                    if (success) {
                        println("Complete")
                    }
                }
            }
            "4" -> {
                return
            }
        }

    }

}