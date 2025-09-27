import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public Task createTask(String description, String start, String end, String priority) throws IllegalArgumentException {
        try {
            LocalTime startTime = LocalTime.parse(start);
            LocalTime endTime = LocalTime.parse(end);
            if (endTime.isBefore(startTime)) {
                throw new IllegalArgumentException("Error: End time must be after start time.");
            }
            return new Task(description, startTime, endTime, priority);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error: Invalid time format. Use HH:MM (24-hour).");
        }
    }
}
