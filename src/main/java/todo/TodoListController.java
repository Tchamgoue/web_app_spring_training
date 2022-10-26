package todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController()
public class TodoListController {

    private final List<Todo> todos= new ArrayList<>();

    @PostMapping("/api/todo")
    void addTodo(@RequestBody Todo todo){
        todos.add(todo);
    }

    @GetMapping("/api/todo")
    Collection<Todo> getTodos(){
        return todos;
    }
}
