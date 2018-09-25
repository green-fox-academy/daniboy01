package com.greenfox.todo;

import com.greenfox.todo.models.Todo;
import com.greenfox.todo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

    private TodoRepository todoRepository;

    public TodoApplication(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Todo todo = new Todo();
        Todo todo2 = new Todo();
        Todo todo3 = new Todo();
        todo.setTitle("feed the cat");
        todo.setDone(true);
        todo2.setTitle("do the washing");
        todo3.setTitle("moov the grow");


        todoRepository.save(todo);
        todoRepository.save(todo2);
        todoRepository.save(todo3);

    }
}
