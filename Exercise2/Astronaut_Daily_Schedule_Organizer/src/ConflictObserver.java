public class ConflictObserver implements Observer {
    @Override
    public void notifyConflict(Task newTask, Task conflictingTask) {
        System.out.println("Error: Task conflicts with existing task \"" + conflictingTask.getDescription() + "\".");
    }
}
