/**
 * A concrete class that reports an invalid string exception if the user has input
 * a string that is not long enough.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 11-09-2020
 */

public class InvalidStringException extends Exception
{
    /**
     * Default InvalidStringException constructor that takes no arguments.
     */
    public InvalidStringException()
    {
    }

    /**
     InvalidStringException constructor that takes 1 parameter.
     @param message displays error message
     */
    public InvalidStringException(String message)
    {
        super(message);
    }

    /**
     * Overriden toString method.
     * @return The string representation of an InvalidStringException.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}