public interface Observer {
    void notifyConflict(Task newTask, Task conflictingTask);
}
