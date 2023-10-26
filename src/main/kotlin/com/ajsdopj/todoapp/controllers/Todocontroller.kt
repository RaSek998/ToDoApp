package com.ajsdopj.todoapp.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController

class Todocontroller {
    var todolist: MutableList<todo> = mutableListOf()

    @GetMapping("/todos")
    fun getToDo(): List<todo>{
        return todolist
    }

    @PostMapping("/todos")
    fun addTodos(@RequestBody inputTodo: todo): todo{

        todolist.add(inputTodo)
        return inputTodo
    }
}