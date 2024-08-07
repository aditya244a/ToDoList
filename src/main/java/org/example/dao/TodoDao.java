package org.example.dao;

import org.example.model.Todo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TodoDao {
    void createTodo(Todo todo);
    List<Todo> getAllTodos();
    Todo getTodoById(int id);
    void updateTodoStatus(int id, String status);
}
