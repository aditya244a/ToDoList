package org.example.service;

import org.example.model.Todo;

import java.util.List;

public interface TodoService {
    void createTodo(Todo todo);
    List<Todo> getAllTodos();
    Todo getTodoById(int id);
    void updateTodoStatus(int id, String status);
}
