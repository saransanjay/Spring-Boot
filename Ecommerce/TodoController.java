package com.springboot.Ecommerce;


import com.springboot.Ecommerce.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getAll()
    {
        return new ResponseEntity<>(todoService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Long id)
    {
        try{
            Todo getTodo = todoService.getById(id);
            return new ResponseEntity<>(getTodo,HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo)
    {
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo)
    {
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteTobo(@PathVariable Long id)
    {
        try{
            todoService.deleteTodo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
