package org.example.controller;

import org.example.model.Todo;
import org.example.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    @PostMapping("/create")
    public String createToDo(@RequestParam String title, @RequestParam String description) {
        Todo todo = new Todo(title,description);
        todoService.createTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateToDoStatus(@RequestParam int id, @RequestParam String status) {
        todoService.updateTodoStatus(id, status);
        return "redirect:/";
    }
}
