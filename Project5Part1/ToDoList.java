import java.util.*;

/**
 * A concrete class that represents a ToDoList by implementing a priority queue.
 * Contains accessors, mutators, an addTask() method, a next() method
 * and an overriden toString() method.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 11-09-2020
 */

public class ToDoList {
    private PriorityQueue<Task> pq;

    /**
     * Default ToDoList constructor that takes no arguments.
     * Creates a new priority queue.
     */
    public ToDoList() {
        pq = new PriorityQueue<>();
    }

    /**
     * A method that adds a task to the priority queue if the following conditions are met.
     * 1) The priority is between 1-9.
     * 2) The description's length is greater than 3 characters.
     * 3) There are no other tasks in the priority queue with the same description as the
     * task that is trying to be added. If a task that is being added has the same description
     * as an existing task in the priority queue, a message will be displayed to the user that
     * states the task will not be added because it is already in the list.
     * Both tasks' hash codes will be displayed.
     * Exceptions will be thrown if the first two conditions aren't met.
     * @param task from the user.
     */
    public void addTask(String task) throws InvalidStringException {
        Scanner in = new Scanner(task.substring(3));

        if(in.hasNextInt()) {
            int priority = in.nextInt();

            if (priority < 1 || priority > 9)
                throw new IllegalArgumentException();

            String description = in.nextLine().trim();

            if(description.length() < 3)
                throw new InvalidStringException();

            boolean containsDuplicate = false;

            for (Task someTask : pq) {
                if (someTask.equals(new Task(priority, description))) {
                    System.out.println("\nThat task already exists...\n");
                    System.out.println("Task Entered: " + new Task(priority, description).toString() + "Hash Code: " + new Task(priority, description).hashCode());
                    System.out.println("Existing Task: " + someTask.toString() + "Hash Code: " + someTask.hashCode());
                    System.out.println("\nPlease enter a task that doesn't already exist:");
                    containsDuplicate = true;
                }
            }
            if (!containsDuplicate)
                pq.add(new Task(priority, description));
        }
        else
            throw new NumberFormatException();
    }

    /**
     * A method that removes and prints the most urgent task if there are tasks in the priority queue.
     * If no tasks are in the priority queue, it will notify the user.
     */
    public void nextTask() {
        Task next = pq.poll();

        if(next != null)
            System.out.println(next.getDescription());
        else
            System.out.println("No tasks are currently in the list...");
    }

    /**
     * Overriden toString method.
     * @return The string representation of a ToDoList.
     */
    @Override
    public String toString() {
        String allTasks = "";
        for(Task t : pq) {
            allTasks += t.toString();
        }
        return allTasks;
    }
}
