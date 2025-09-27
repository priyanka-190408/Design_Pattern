import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictObserver()); // attach observer
        TaskFactory factory = new TaskFactory();

        while (true) {
            System.out.println("\n=== Astronaut Daily Schedule Organizer ===");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. View Tasks by Priority");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. Edit Task");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter start time (HH:MM): ");
                        String start = sc.nextLine();
                        System.out.print("Enter end time (HH:MM): ");
                        String end = sc.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String pr = sc.nextLine();
                        Task task = factory.createTask(desc, start, end, pr);
                        manager.addTask(task);
                        break;
                    case "2":
                        System.out.print("Enter description of task to remove: ");
                        String removeDesc = sc.nextLine();
                        manager.removeTask(removeDesc);
                        break;
                    case "3":
                        manager.viewTasks();
                        break;
                    case "4":
                        System.out.print("Enter priority to view: ");
                        String priority = sc.nextLine();
                        manager.viewTasksByPriority(priority);
                        break;
                    case "5":
                        System.out.print("Enter description of task to mark completed: ");
                        String completeDesc = sc.nextLine();
                        manager.markTaskCompleted(completeDesc);
                        break;
                    case "6":
                        System.out.print("Enter description of task to edit: ");
                        String oldDesc = sc.nextLine();
                        System.out.print("Enter new description: ");
                        String newDesc = sc.nextLine();
                        System.out.print("Enter new start time (HH:MM): ");
                        String newStart = sc.nextLine();
                        System.out.print("Enter new end time (HH:MM): ");
                        String newEnd = sc.nextLine();
                        System.out.print("Enter new priority (High/Medium/Low): ");
                        String newPr = sc.nextLine();
                        manager.editTask(oldDesc, newDesc, newStart, newEnd, newPr, factory);
                        break;
                    case "7":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
