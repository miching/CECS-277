import java.util. * ;

/**
 * A concrete tester for various methods of the WordProcessor class.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 11-18-2020
 */
public class WordTester {

    /**
     * Extensively tests inserting characters, moving the cursor left and right,
     * searching for and deleting characters, the backspace function, invalid commands
     * and moving to the start and end.
     * @param args
     */
    public static void main(String[] args)
    {

        Queue<String> commandqueue = new LinkedList<String>();

        System.out.println("Possible commands: \n"
                + "insert, move left, move right, search, delete, backspace, move to start, move to end");

        commandqueue.add("insert J");
        commandqueue.add("insert K");
        commandqueue.add("insert L");
        commandqueue.add("move left");
        commandqueue.add("move right");
        commandqueue.add("move left");
        commandqueue.add("move left");
        commandqueue.add("search K");
        commandqueue.add("delete");
        commandqueue.add("backspace");
        commandqueue.add("fffffff");
        commandqueue.add("move to start");
        commandqueue.add("move to end");
        commandqueue.add("blaj");
        commandqueue.add("move to start");
        commandqueue.add("search i");




        System.out.println("Starting Word Processor!");
        System.out.println("------------------------");

        //Content to begin document with
        WordProcessor newDoc = new WordProcessor("Initial Content");

        Iterator<String> itr = commandqueue.iterator();

        //As long as there are still commands
        while (itr.hasNext())
        {

            newDoc.processCommand(itr.next());

        }

    }

}
