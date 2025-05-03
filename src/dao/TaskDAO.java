package dao;

import model.Task;
import util.DBConnection;

import java.sql.*;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public boolean addTask(Task task) {
        String sql = "INSERT INTO tasks (title, description, status, due_date, user_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, task.getTitle());
	            stmt.setString(2, task.getDescription());
	            stmt.setString(3, task.getStatus());
	            stmt.setDate(4, Date.valueOf(task.getDueDate()));
	            stmt.setInt(5, task.getUserId());
	            	return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Task> getTasksByUser(int userId) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task task = new Task(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getDate("due_date").toLocalDate(),
                    rs.getInt("user_id")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public boolean updateTask(Task task) {
        String sql = "UPDATE tasks SET title = ?, description = ?, status = ?, due_date = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStatus());
            stmt.setDate(4, Date.valueOf(task.getDueDate()));
            stmt.setInt(5, task.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTask(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, taskId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
