import java.util.*;

/**
 * A concrete class that implements various WordProcessor constructors as well as
 * methods to see and control where the cursor is. Implements methods to manipulate and
 * move characters as well.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 11-18-2020
 */
public class WordProcessor implements MiniWPI
{

    /**
     * Default Constructor
     */
    public WordProcessor()
    {

        // Prints out initial contents of stacks
        System.out.println("Initial: " + toStringCursor());
        

    }

    /**
     * Constructor that takes in initial string and puts it in the left stack character by character
     * @param s Initial String
     */
    public WordProcessor(String s)
    {

        // Takes initial string and puts it in the left stack character by character
        for (int i = 0; i < s.length(); i++)
        {

            left.push(s.charAt(i));

        }

        // Prints out initial contents of stacks
        System.out.println("Initial: " + toStringCursor());
    }


    /**
     * Checks to see if cursor is at the start of the text
     * @return boolean Whether or not cursor is at the start of the text
     */
    public boolean isAtStart()
    {

        // If the cursor is at the start, then the left stack must be empty
        if (left.empty())
        {

            return true;

        }

        return false;

    }

    /**
     * Checks to see if cursor is at the end of the text
     * @return boolean Whether or not cursor is at end of the text
     */
    public boolean isAtEnd()
    {

        // If the cursor is at the end, then the right stack must be empty
        if (right.empty())
        {

            return true;

        }

        return false;

    }

    /**
     * Insert a character into the string at the cursor
     * @param c A character to be inserted
     */
    public void insertChar(char c)
    {

        left.push(c);

    }

    /**
     * Move cursor left 1 character. If we're already at the start of the string, do
     * nothing.
     */
    public void moveLeft()
    {

        // Does nothing if the cursor is already at the beginning. If not at beginning,
        // pop from left stack and push that element to right stack.
        if (!isAtStart())
        {

            right.push(left.pop());

        }

    }

    /**
     * Move cursor right 1 character. If we're already at the end of the string, do
     * nothing.
     */
    public void moveRight()
    {

        // Does nothing if the cursor is already at the end. If not at end, pop from
        // right stack and push that element to left stack.
        if (!isAtEnd())
        {

            left.push(right.pop());

        }
    }

    /**
     * Delete character before the cursor. If there is none, do nothing.
     */
    public void backspace()
    {

        left.pop();

    }

    /**
     * Delete character after the cursor. If there is none, do nothing.
     */
    public void delete()
    {

        right.pop();

    }

    /**
     *  Move cursor to start of the text.
     */
    public void moveToStart()
    {

        // If not at start, pop from left stack and push that element to right stack.
        while (!isAtStart())
        {

            right.push(left.pop());

        }

    }

    /**
     *  Move cursor to end of the text.
     */
    public void moveToEnd()
    {

        // If not at end, pop from right stack and push that element to left stack.
        while (!isAtEnd())
        {

            left.push(right.pop());

        }

    }

    /**
     * Convert to string. The cursor position is ignored.
     * @return String with both left and right stack, without a cursor character
     *
     * @see toStringCursor
     */
    public String toString()
    {

        // Reverse right stack
        Stack<Character> rstack = (Stack<Character>) right.clone();
        Stack<Character> rstackreverse = new Stack<Character>();
        while (!rstack.empty())
        {

            rstackreverse.add(rstack.pop());

        }

        // Return a string with both left and right stack, without a cursor character
        return left.toString() + rstackreverse.toString();
    }

    /**
     * Like toString, but the special character | is included to mark the cursor
     * position.
     *
     * @return String with both left and right stack, with a cursor character
     */
    public String toStringCursor()
    {

        // Reverse right stack
        Stack<Character> rstack = (Stack<Character>) right.clone();
        Stack<Character> rstackreverse = new Stack<Character>();
        while (!rstack.empty())
        {

            rstackreverse.add(rstack.pop());

        }

        // Return a string with both left and right stack, with a cursor character
        return left.toString() + " | " + rstackreverse.toString();
    }

    /**
     * Search forward for the next occurrence of c that starts at the cursor or
     * later. If found, leave the cursor immediately after that occurrence and
     * return true. Else, leave the cursor at the end of the text and return false.
     * @param c Character to be searched
     * @return Whether desired character was found
     */

    public boolean search(char c)
    {

        // Checks right stack until the element is found or the cursor reaches the
        // stack's end
        while (!isAtEnd())
        {


            // Checks if next element equals the search character. Moves cursor to the right
            // and returns "true" if there is a match.
            if (right.peek().equals(c))
            {

                moveRight();
                return true;

            }

            // Moves to next character
            moveRight();
        }

        //	System.out.println("FAIL");
        // Returns false if search character is never found
        return false;
    }

    /**
     * Method that reads in the string that was retrieved from the top of the Queue
     * and executes the appropriate command. It also calls a method to print out the
     * command just executed and the resulting stacks
     * @param s String of the desired command
     */
    public void processCommand(String s)
    {

        // Determine the command
        if (s.toLowerCase().contains("insert"))
        {

            // Gets the letter to insert
            char inChar = s.charAt(s.length() - 1);
            insertChar(inChar);

        }
        else if (s.toLowerCase().equals("move left"))
        {

            moveLeft();

        }
        else if (s.toLowerCase().equals("move right"))
        {

            moveRight();

        }
        else if (s.toLowerCase().contains("search"))
        {

            // Gets letter to find
            char findChar = s.charAt(s.length() - 1);
            search(findChar);

        }
        else if (s.toLowerCase().contains("delete"))
        {
            if(right.empty())
            {

                System.out.println("Empty");

            }
            else
            {

                delete();

            }


        }
        else if (s.toLowerCase().contains("backspace"))
        {

            if(left.empty())
            {

                System.out.println("Empty");

            }
            else
            {

                backspace();

            }

        }
        else if (s.toLowerCase().equals("move to start"))
        {

            moveToStart();

        }

        else if (s.toLowerCase().equals("move to end"))
        {

            moveToEnd();

        }

        else
        {

            System.out.println("Invalid command");

        }

        // Call method to print the command and result
        printtest(s);

    }

    /**
     *  Method to print out a command and the results
     *  @param s String Results of command
     */
    public void printtest(String s) {
        System.out.println(s + ": " + toStringCursor());
    }
}