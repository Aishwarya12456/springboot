package com.javatechie.example1.controller;



import com.javatechie.example1.model.Task;
import com.javatechie.example1.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "Task management endpoints")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @Operation(summary = "Create new task", description = "Creates a task and returns it")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        try {
            Task createdTask = taskService.createTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get task by ID")
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        try {
            List<Task> tasks = taskService.getAllTasks();
            if (tasks.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(
            @Parameter(description = "Task ID") @PathVariable Long id) {
        Optional<Task> taskData = taskService.getTaskById(id);
        return taskData
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            boolean deleted = taskService.deleteTask(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> markComplete(@PathVariable Long id) {
        Task task = taskService.markComplete(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{completed}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable boolean completed) {
        try {
            List<Task> tasks = taskService.getTasksByStatus(completed);
            if (tasks.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam String keyword) {
        try {
            List<Task> tasks = taskService.searchTasks(keyword);
            if (tasks.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

































//
//    // In-memory storage
//    private Map<String, Task> taskStore = new HashMap<>();
//    private int idCounter = 1;
//
//
//    @PostMapping
//    public Task createTask(@RequestBody Task task) {
//        String id = String.valueOf(idCounter++);
//        task.setId(id);
//        taskStore.put(id, task);
//        return task;
//    }
//
//
//    @GetMapping
//    public List<Task> getAllTasks() {
//        return new ArrayList<>(taskStore.values());
//    }
//
//
//    @PutMapping("/update/{id}")
//    public Task updatetask(@PathVariable String id,@RequestBody Task task) {
//        if(!taskStore.containsKey(id)){
//            throw new RuntimeException("Not Found data");
//        }
//
//           task.setId(id);
//        taskStore.put(id, task);
//        return task;
//    }
//
//    @DeleteMapping("/remove/{id}")
//    public String removeStudent(@PathVariable String id) {
//        if(!taskStore.containsKey(id)){
//            throw new RuntimeException("Not Found ID");
//        }
//          taskStore.remove(id);
//         return  "Task is removed";
//    }
//
//    @PatchMapping("/upt/{id}")
//    public Task partialUpdate(@PathVariable String id,@RequestBody Task newtask){
//        Task old = taskStore.get(id);
//        if(!taskStore.containsKey(id)){
//            throw new RuntimeException("ID not Found");
//        }
//            newtask.setId(id);
//         if(newtask.getDescription() != null){
//             old.setDescription(newtask.getDescription());
//         }
//         if(newtask.getTitle() != null){
//             old.setTitle(newtask.getTitle());
//         }
//
//        return  old;
//    }

}