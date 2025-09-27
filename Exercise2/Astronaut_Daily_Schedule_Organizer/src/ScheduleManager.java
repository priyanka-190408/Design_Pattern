import java.util.*;
import java.util.stream.Collectors;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(ScheduleManager.class.getName());

    // static block to configure logging once
    static {
        try {
            FileHandler fh = new FileHandler("schedule.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            System.err.println("Logging setup failed: " + e.getMessage());
        }
    }

    private ScheduleManager() {}

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addTask(Task task) {
        for (Task existing : tasks) {
            boolean overlap = !(task.getEndTime().isBefore(existing.getStartTime())
                    || task.getStartTime().isAfter(existing.getEndTime()));
            if (overlap) {
                for (Observer o : observers) {
                    o.notifyConflict(task, existing);
                }
                logger.warning("Conflict when adding task: " + task.getDescription());
                return;
            }
        }
        tasks.add(task);
        System.out.println("Task added successfully. No conflicts.");
        logger.info("Added task: " + task.getDescription());
    }

    public void removeTask(String description) {
        Optional<Task> taskToRemove = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (taskToRemove.isPresent()) {
            tasks.remove(taskToRemove.get());
            System.out.println("Task removed successfully.");
            logger.info("Removed task: " + description);
        } else {
            System.out.println("Error: Task not found.");
            logger.warning("Task not found for removal: " + description);
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        List<Task> sorted = tasks.stream()
                .sorted(Comparator.comparing(Task::getStartTime))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    public void viewTasksByPriority(String priority) {
        List<Task> filtered = tasks.stream()
                .filter(t -> t.getPriority().equalsIgnoreCase(priority))
                .sorted(Comparator.comparing(Task::getStartTime))
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("No tasks with priority " + priority + ".");
        } else {
            filtered.forEach(System.out::println);
        }
    }

    public void markTaskCompleted(String description) {
        Optional<Task> task = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (task.isPresent()) {
            task.get().markCompleted();
            System.out.println("Task marked as completed.");
            logger.info("Task marked completed: " + description);
        } else {
            System.out.println("Error: Task not found.");
            logger.warning("Task not found to mark completed: " + description);
        }
    }

    // New: Edit an existing task
    public void editTask(String oldDescription, String newDescription,
                         String newStart, String newEnd, String newPriority, TaskFactory factory) {
        Optional<Task> existingTask = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(oldDescription))
                .findFirst();
        if (existingTask.isEmpty()) {
            System.out.println("Error: Task not found.");
            logger.warning("Edit failed - Task not found: " + oldDescription);
            return;
        }

        // Temporarily remove the old task to avoid self-overlap
        Task oldTask = existingTask.get();
        tasks.remove(oldTask);

        try {
            Task newTask = factory.createTask(newDescription, newStart, newEnd, newPriority);

            // Check overlap with remaining tasks
            for (Task t : tasks) {
                boolean overlap = !(newTask.getEndTime().isBefore(t.getStartTime())
                        || newTask.getStartTime().isAfter(t.getEndTime()));
                if (overlap) {
                    for (Observer o : observers) {
                        o.notifyConflict(newTask, t);
                    }
                    tasks.add(oldTask); // rollback
                    logger.warning("Conflict when editing task: " + oldDescription);
                    return;
                }
            }

            tasks.add(newTask);
            System.out.println("Task edited successfully.");
            logger.info("Edited task: " + oldDescription + " -> " + newDescription);
        } catch (IllegalArgumentException e) {
            tasks.add(oldTask); // rollback on error
            System.out.println(e.getMessage());
            logger.warning("Edit failed for task " + oldDescription + " due to " + e.getMessage());
        }
    }
}
