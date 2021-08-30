import java.util.Objects;

/**
 * A concrete class that represents a single task with a priority & description, implements Comparable.
 * Contains accessors, mutators and an overriden equals(), hashCode(),
 * compareTo() and toString() method.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 11-09-2020
 */

public class Task implements Comparable<Task>{
    private int priority;
    private String description;

    /**
     * Default Task constructor that takes no arguments.
     */
    public Task() {}

    /**
     * Task constructor that takes 2 parameters.
     * @param priority the priority level the user inputs
     * @param description the task the user inputs
     */
    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    /**
     * Sets the priority.
     * @param priority the priority level the user inputs
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Sets the description.
     * @param description the task the user inputs
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the priority.
     * @return priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the description.
     * @return description the task the user inputs
     */
    public String getDescription() {
        return description;
    }

    /**
     * Overriden equals method.
     * Checks to see if two different objects have the same description.
     * If they do, they are equal.
     * @param obj
     * @return true or false based on conditions
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj instanceof Task) {
            Task t = (Task)obj;
            if (t.getDescription().equalsIgnoreCase(this.description))
                return true;
        }
        return false;
    }

    /**
     * Overriden hashCode method.
     * Assigns hash codes to objects, will assign the same hash code to objects that are equal.
     * @return an integer hash code
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.description.toLowerCase());

        return hash;
    }

    /**
     * Overriden compareTo method.
     * Compares and determines which task has higher priority based on their priority value (the priority instance variable).
     * @param otherTask being compared
     * @return -1, 0 or 1 depending on the value after the expression
     */
    @Override
    public int compareTo(Task otherTask) {
        return Integer.compare(this.priority, otherTask.priority);
    }

    /**
     * Overriden toString method.
     * @return The string representation of a Task object.
     */
    @Override
    public String toString() {
        return "\nPriority: " + priority + ", Description: " + description + "\n";
    }
}
