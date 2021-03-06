package com.greenfox.todo.controllers;

import com.greenfox.todo.models.Todo;
import com.greenfox.todo.repository.TodoRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class TodoController {

    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @GetMapping (value = {"/todo", "/"})
    public String list(@RequestParam(required = false) Boolean isActive , Model model) {
        if (isActive == null) {
            model.addAttribute("todoList", todoRepository.findAll());
        } else if (isActive == true) {
            List<Todo> isNotDone = Streamable.of(todoRepository.findAll()).stream()
                    .filter(a -> !a.isDone())
                    .collect(Collectors.toList());
            model.addAttribute("todoList", isNotDone);
        } else if (isActive == false) {
            List<Todo> isNotDone = Streamable.of(todoRepository.findAll()).stream()
                    .filter(a -> a.isDone())
                    .collect(Collectors.toList());
            model.addAttribute("todoList", isNotDone);

        }
        return "todo";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }






}

