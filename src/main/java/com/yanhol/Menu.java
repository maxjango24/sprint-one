package com.yanhol;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private final TaskManager taskManager = new TaskManager();
    private final Scanner scanner = new Scanner(System.in);
    private boolean isOn = true;

    public void start() {
        while (isOn) {
            showMenu();
            System.out.print("Choose option: ");
            String choice = scanner.next();
            switch (choice) {
                case "1" -> addTaskMenu();
                case "2" -> removeTaskMenu();
                case "3" -> markDoneMenu();
                case "4" -> taskManager.listTasks();
                case "5" -> findTaskByIdMenu();
                case "0" -> {
                    System.out.println("Goodbye!");
                    isOn = false;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void addTaskMenu() {
        scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine();

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(LocalDate.parse(deadline));

        taskManager.addTask(task);
    }

    private void removeTaskMenu() {
        System.out.print("Enter task ID to remove: ");
        int id = scanner.nextInt();
        taskManager.removeTask(id);
    }

    private void markDoneMenu() {
        System.out.print("Enter task ID to mark done: ");
        int id = scanner.nextInt();
        taskManager.markAsDone(id);
    }

    private void findTaskByIdMenu() {
        System.out.print("Enter to find task ID: ");
        int id = scanner.nextInt();
        Task task = taskManager.findTaskById(id);
        System.out.println(task);
    }

    private static void showMenu() {
        System.out.println("""
                === Task Manager ===
                1. Add task
                2. Remove task
                3. Mark as done
                4. List tasks
                5. Find Task by Id
                0. Exit
                """);
    }
}
