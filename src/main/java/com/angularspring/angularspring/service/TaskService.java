package com.angularspring.angularspring.service;

import com.angularspring.angularspring.entity.Task;
import com.angularspring.angularspring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks for a specific user
    public List<Task> getTasksByUserId(String userId) {
        return taskRepository.findByUserId(userId);
    }

    // Add a new task for a user
    public Task addTask(String userId, Task task) {
        task.setUserId(userId);  // make sure userId is set
        return taskRepository.save(task);
    }

    // Remove a task by its ID
    public void removeTask(long taskId) {
        taskRepository.deleteById(taskId);
    }
}