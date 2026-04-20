package at.technikum.backend.service;

import at.technikum.backend.entity.Todo;
import at.technikum.backend.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo add(String name) {
        Todo todo = new Todo(name);
        return todoRepository.save(todo);
    }
}
