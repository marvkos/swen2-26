package at.technikum.backend.controller;

import at.technikum.backend.dto.TodoDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!!!";
    }

    @RequestMapping("/test/todo")
    public TodoDto testDto() {
        return new TodoDto(1, "Shopping", false);
    }
}
