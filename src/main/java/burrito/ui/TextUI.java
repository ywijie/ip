package burrito.ui;

import burrito.tasklist.*;
import java.util.List;

public class TextUI {

    private static final String lineseperator = "____________________________________________________________";

    public TextUI() { }

    /**
     * Prints the contents of the Task List
     *
     * @return void.
     */
    static public void list(List<Task> cache) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < cache.size(); i++) {
            int tempi = i + 1;

            System.out.println(tempi + ". " + cache.get(i).toString());

        }
    }



    /**
     * Message for terminating the program
     *
     * @return void.
     */
    static public void bye() {
        System.out.println("Bye. Hope to see you again soon!");

    }

    /**
     * Welcome message for program initialisation
     *
     * @return void.
     */
    static public void welcome() {
        System.out.println(lineseperator);
        System.out.println("Hello! I'm Burrito.\nWhat can I do for you?");
        System.out.println(lineseperator);

    }


}
