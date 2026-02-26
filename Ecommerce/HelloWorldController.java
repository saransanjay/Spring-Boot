package com.springboot.Ecommerce;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class HelloWorldController {

    @GetMapping
    public String getAll(){
        return "all Get";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable long id)
    {
        return "Get By "+id;
    }

    @PostMapping
    public String create(@RequestBody String body)
    {
        return "Create "+body;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id)
    {
        return "Update "+id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id)
    {
        return "Delete "+id;
    }

}

