package org.example.service;

import org.example.dao.TodoDao;
import org.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoDao TodoDao;

    public TodoServiceImpl(TodoDao todoDao) {
        TodoDao = todoDao;
    }

    public void createTodo(Todo todo) {
        TodoDao.createTodo(todo);
    }

    public List<Todo> getAllTodos() {
        return TodoDao.getAllTodos();
    }

    @Override
    public Todo getTodoById(int id) {
        return TodoDao.getTodoById(id);
    }

    public void updateTodoStatus(int id, String status) {
        TodoDao.updateTodoStatus(id, status);
    }
}
