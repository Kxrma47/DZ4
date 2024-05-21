package org.example.todo.service;

import org.example.todo.model.Task;
import org.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(String description) {
        Task task = new Task();
        task.setDescription(description);
        return taskRepository.save(task);
    }

    public void removeTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}