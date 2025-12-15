
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
        
    }

}