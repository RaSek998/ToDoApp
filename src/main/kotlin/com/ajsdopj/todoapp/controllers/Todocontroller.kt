package com.ajsdopj.todoapp.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController

class Todocontroller {
    var todolist: MutableList<Todo> = mutableListOf()

    @GetMapping("/todos")
    fun getToDo(): List<Todo>{
        return todolist
    }

    @PostMapping("/todos")
    fun addTodos(@RequestBody inputTodo: Todo): Todo{

        todolist.add(inputTodo)
        return inputTodo
    }

    @GetMapping("/todos/{id}")
    fun getPersonById( @PathVariable id: Int): Todo? {
        val todo = todolist.firstOrNull {
            it.id == id
        }

        if (todo != null){
            return todo
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "The Todo with id $id was not found")
        }
    }

    @DeleteMapping("/todos/{name}")
    fun delete (@PathVariable name: String): Todo? {
        val todo = todolist.firstOrNull {
            it.name == name
        }

        if(todo != null) {
            todolist.remove(todo)
            return todo
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "The Todo with name $name was not found")
        }

    }

}