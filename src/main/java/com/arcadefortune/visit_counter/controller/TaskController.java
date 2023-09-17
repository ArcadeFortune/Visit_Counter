// https://www.youtube.com/watch?v=qVNOw9TWwxo&ab_channel=JavaTechie
//package com.arcadefortune.visit_counter.controller;
//
//import com.arcadefortune.visit_counter.model.Task;
//import com.arcadefortune.visit_counter.service.TaskService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/tasks")
//public class TaskController {
//
//    @Autowired
//    private TaskService service;
//
//    // create
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Task createTask(@RequestBody Task task) {
//        return service.addTask(task);
//    }
//
//    // https://stackoverflow.com/questions/60535579/get-client-ip-address-in-spring-boot-security
//    // create new IP
//    @GetMapping("/ip")
//    public String getDeviceList(HttpServletRequest httpServletRequest){
//        return httpServletRequest.getRemoteAddr();
//    }
//
//    // read
//    @GetMapping
//    public List<Task> getTasks() {
//        return service.findAllTasks();
//    }
//
//    // read by ID
//    @GetMapping("/{taskId}")
//    public Task getTask(@PathVariable String taskId) {
//        return service.getTaskByTaskId(taskId);
//    }
//
//    // read total amount of entries
//    @GetMapping("/total")
//    public long getTotalAmountOfTasks() {
//        return service.getAmountOfTasks();
//    }
//
//    // update
//    @PutMapping
//    public Task updateTask(@RequestBody Task task) {
//        return service.updateTask(task);
//    }
//
//    // delete
//    @DeleteMapping("/{taskId}")
//    public String deleteTask(@PathVariable String taskId) {
//        return service.deleteTask(taskId);
//    }
//}
