package com.angularspring.angularspring.controller;

import com.angularspring.angularspring.entity.Task;
import com.angularspring.angularspring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200") // allow Angular dev server
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/user/{userId}")
    public List<Task> getUserTasks(@PathVariable String userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public Task addTask(@PathVariable String userId, @RequestBody Task task) {
        return taskService.addTask(userId, task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable long taskId) {
        taskService.removeTask(taskId);
    }
}