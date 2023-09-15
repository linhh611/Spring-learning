package app.controller;

import app.model.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    private List<Todo> todoList = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init() {
        todoList.add(null);
    }

    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        return todoList;
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) {

        return todoList.get(todoId);
    }

    @PutMapping("/todo/{todoId}")
    public Todo editTodo(@PathVariable(name = "todoId") Integer todoId,
                         @RequestBody Todo todo) {
        todoList.set(todoId, todo);
        return todo;
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Integer todoId) {
        todoList.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        todoList.add(todo);
        return ResponseEntity.ok().body(todo);
    }
}
