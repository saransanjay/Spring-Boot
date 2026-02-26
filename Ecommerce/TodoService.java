package com.springboot.Ecommerce;

import com.springboot.Ecommerce.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    //  Get All Todo List
    public List<Todo> getAll()
    {
        return todoRepository.findAll();
    }

    //  Get All Todo List
    public Todo getById(Long id)
    {
        return todoRepository.findById(id).orElseThrow(()->new RuntimeException("Todo List Found with this Id "+id));
    }

    //  Create Todo List
    public Todo createTodo(Todo todo)
    {
        return todoRepository.save(todo);
    }

    //  Update Todo List
    public Todo updateTodo(Todo todo)
    {
        return todoRepository.save(todo);
    }
    //  Update Todo List
    public void deleteTodo(Long id)
    {
         todoRepository.deleteById(id);
    }



}
