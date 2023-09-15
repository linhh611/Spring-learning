package app;

import app.Todo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    private List<Todo> todoList;

    @PostConstruct
    public void init() {
        todoList = IntStream.range(0,10)
                .mapToObj(i -> new Todo("title-" +i, "detail-" +i))
                .collect(Collectors.toList());
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId")Integer todoId) {
        return todoList.get(todoId);
    }

}
