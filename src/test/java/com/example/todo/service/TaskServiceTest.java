package com.example.todo.service;

import org.example.todo.model.Task;
import org.example.todo.repository.TaskRepository;
import org.example.todo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void testAddTask() {
        Task task = new Task();
        task.setDescription("Test Task");

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.addTask("Test Task");

        assertEquals("Test Task", createdTask.getDescription());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void testRemoveTask() {
        Long taskId = 1L;
        doNothing().when(taskRepository).deleteById(taskId);

        taskService.removeTask(taskId);

        verify(taskRepository, times(1)).deleteById(taskId);
    }

    @Test
    void testGetAllTasks() {
        Task task1 = new Task();
        task1.setDescription("Task 1");

        Task task2 = new Task();
        task2.setDescription("Task 2");

        List<Task> tasks = Arrays.asList(task1, task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getDescription());
        assertEquals("Task 2", result.get(1).getDescription());
        verify(taskRepository, times(1)).findAll();
    }
}