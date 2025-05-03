package controller;

import dao.TaskDAO;
import model.Task;

import java.util.List;

public class TaskController {
    private final TaskDAO taskDAO = new TaskDAO(); /* Invoke the Task DAO */

    /* Add a Task to DB */
    public boolean createTask(Task task) {
        return taskDAO.addTask(task);
    }

    /* Get a Task to DB */
    public List<Task> getUserTasks(int userId) {
        return taskDAO.getTasksByUser(userId);
    }

    /* Update a Task to DB */
    public boolean updateTask(Task task) {
        return taskDAO.updateTask(task);
    }

    /* Delete a Task to DB */
    public boolean deleteTask(int taskId) {
        return taskDAO.deleteTask(taskId);
    }
}
