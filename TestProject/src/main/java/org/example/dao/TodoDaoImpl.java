package org.example.dao;

import org.example.model.Todo;
import org.example.util.DatabaseUtil;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoDaoImpl implements TodoDao {

    @Override
    public void createTodo(Todo todo) {
        String sql = "INSERT INTO todos (title, description, status) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, todo.getTitle());
            statement.setString(2, todo.getDescription());
            statement.setString(3, todo.getStatus());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos ORDER BY created_at DESC";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Todo todo = new Todo();
                todo.setId(resultSet.getInt("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
                todo.setStatus(resultSet.getString("status"));
                todo.setCreatedAt(resultSet.getTimestamp("created_at"));
                todos.add(todo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        Todo todo = null;
        String sql = "SELECT * FROM todos WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    todo = new Todo();
                    todo.setId(resultSet.getInt("id"));
                    todo.setTitle(resultSet.getString("title"));
                    todo.setDescription(resultSet.getString("description"));
                    todo.setStatus(resultSet.getString("status"));
                    todo.setCreatedAt(resultSet.getTimestamp("created_at"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todo;
    }

    @Override
    public void updateTodoStatus(int id, String status) {
        String sql = "UPDATE todos SET status = ? WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, status);
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
