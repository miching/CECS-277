import java.util.*;

/**
 * A tester class that tests various aspects of the program.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 11-09-2020
 */

public class ToDoListTester
{
    /**
     * Extensively tests the following:
     * 1) The addTask() method.
     * 2) The nextTask() method.
     * 3) Ending the program if the user enters "quit" as an option.
     * 4) Catching various exceptions that the ToDoList methods the main method throws...
     * Ex) Entering nothing, entering a priority that's not 1, 9 or between 1 & 9,
     * entering an invalid option, entering a string as a priority, etc.
     * @param args from the command line
     */
    public static void main(String[] args)
    {
        ToDoList list = new ToDoList();
        Scanner in = new Scanner(System.in);
        String task;

        System.out.println("To Do List - Please enter an option\n" +
            "   add priority description (add a new task)\n" +
            "   next (remove and print most urgent task)\n" +
            "   quit (exit this program)");

        boolean stillChoosing = true;

        do {
            System.out.print("> ");
            task = in.nextLine();

            try {
                if (task.toLowerCase().startsWith("add ")) {
                    list.addTask(task);
                }
                else if (task.equalsIgnoreCase("next"))
                    list.nextTask();
                else if (task.equalsIgnoreCase("quit"))
                    stillChoosing = false;
                else
                    throw new InputMismatchException();
            }
            catch (StringIndexOutOfBoundsException e) {
                System.out.println("\nYou haven't entered a valid option.\nPlease try again:");
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid option, enter add, next or quit.\nPlease try again:");
            }
            catch (NumberFormatException e) {
                System.out.println("\nPriority must be a whole number that's not spelled out.\nPlease try again:");
            }
            catch (IllegalArgumentException e) {
                System.out.println("\nEnter a priority between 1-9.\nPlease try again:");
            }
            catch (InvalidStringException e) {
                System.out.println("\nDescription must be longer than 3 characters.\nPlease try again:");
            }
        } while(stillChoosing);

        in.close();
    }
}

