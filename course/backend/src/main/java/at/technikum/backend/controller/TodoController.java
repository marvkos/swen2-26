package at.technikum.backend.controller;

import at.technikum.backend.dto.TodoDto;
import at.technikum.backend.entity.Todo;
import at.technikum.backend.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo create(@RequestBody TodoDto todoDto) {
        return todoService.add(todoDto.getName());
    }

    @GetMapping("/{id}")
    public TodoDto read(@PathVariable int id) {
        return new TodoDto("kitchen");
    }

    @GetMapping
    public List<TodoDto> readAll() {
        return null;
    }

    @PutMapping("/{id}")
    public TodoDto update() {
        return null;
    }

    @DeleteMapping("/{id}")
    public TodoDto delete() {
        return null;
    }
}
