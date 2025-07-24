package com.yanhol;

import java.util.ArrayList;


public class TaskManager {

    private final ArrayList<Task> tasks = new ArrayList<>();
    private int counter;


    public void addTask(Task task) {
        counter++;
        task.setId(counter);
        tasks.add(task);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void markAsDone(int id) {
        tasks.stream().filter(task -> task.getId() == id).findFirst().ifPresent(task -> {
            task.setDone(true);
        });
    }

    public void listTasks() {
        System.out.println("All tasks:");
        tasks.forEach(System.out::println);
    }

    public Task findTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst()
                .orElseThrow(() -> new TaskNotFoundException("No task with id " + id));
    }


}
