import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Burrito {

    static List<Task> cache = new ArrayList<>();
    static String[] commands = {"bye", "list", "mark", "unmark", "todo", "deadline", "event"};
    static String lineseperator = "____________________________________________________________";




    /**
     * Prints the contents of the Task List
     *
     * @return void.
     */
    static public void list() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < cache.size(); i++) {
            int tempi = i + 1;
            System.out.println(tempi + ". [" + cache.get(i).getType() + "] [" + cache.get(i).getStatusIcon() + "] "
                    + cache.get(i).getDescription());

        }
    }

    /**
     * Marks task as done
     *
     * @param inputArr User input
     * @return void.
     */
    static public void mark(String[] inputArr) {
        if (inputArr.length <= 1) {
            System.out.println("Sorry! you didn't specify the index.");
        } else {
            try {
                cache.get(Integer.parseInt(inputArr[1]) - 1).setStatus(true);
                System.out.println("Nice! I've marked this task as done.");
                System.out.println(cache.get(Integer.parseInt(inputArr[1]) - 1).toString());

            } catch (Exception e) {
                System.out.println("Wrong formatting for index!");
            } finally { }
        }
    }

    /**
     * Marks task as undone
     *
     * @param inputArr User input
     * @return void.
     */
    static public void unmark(String[] inputArr) {
        if (inputArr.length <= 1) {
            System.out.println("Sorry! you didn't specify the index.");
        } else {
            try {
                cache.get(Integer.parseInt(inputArr[1]) - 1).setStatus(false);
                System.out.println("Nice! I've marked this task as not done yet.");
                System.out.println(cache.get(Integer.parseInt(inputArr[1]) - 1).toString());


            } catch (Exception e) {
                System.out.println("Wrong formatting for index!" + e.getMessage());
            } finally {
            }
        }
    }

    /**
     * Creates todo task and adds it to cache
     *
     * @param inputArr User input
     * @return void.
     */
    static public void todo(String[] inputArr) {
        cache.add(new Todo(inputArr[1]));
        System.out.println("Got it. I've added this task:");
        System.out.println(cache.get(cache.size() - 1).toString());
        System.out.println("Now you have " + cache.size() + " task(s) in the list.");

    }

    /**
     * Creates deadline task and adds it to cache
     *
     * @param inputArr User input
     * @return void.
     */
    static public void deadline(String[] inputArr) {
        String[] newInputArr = inputArr[1].split(" /by ", 2);
        try {
            cache.add(new Deadline(newInputArr[0], newInputArr[1]));
            System.out.println("Got it. I've added this task:");
            System.out.println(cache.get(cache.size() - 1).toString());
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Something went wrong, check your syntax! (seperate with \"/by\"");

        } finally {}

    }

    /**
     * Creates event task and adds it to cache
     *
     * @param inputArr User input
     * @return void.
     */
    static public void event(String[] inputArr) {
        String[] newInputArr = inputArr[1].split(" /from ", 2);
        String[] newInputArr2 = newInputArr[1].split(" /to ", 2);

        try {
            cache.add(new Event(newInputArr[0], newInputArr2[0], newInputArr2[1]));
            System.out.println("Got it. I've added this task:");
            System.out.println(cache.get(cache.size() - 1).toString());
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Something went wrong, check your syntax! (seperate with \"/from\" and \"/to\"");

        } finally {}

    }

    /**
     * Message for terminating the program
     *
     * @return void.
     */
    static public void bye() {
        System.out.println("Bye. Hope to see you again soon!");

    }

    public static void main(String[] args) {
        /*String logo = " ____                      _        \n"
                + "|  _ \\                  (_) |       \n"
                + "| |_) |  _   _ _ __ _ __ _| |_ ___  \n"
                + "|  _ <  | | | | .--| .--| | __/   \\ \n"
                + "| |_) | | |_| | |  | |  | | || (_) |\n"
                + "|____/   \\__,_|_|  |_|  |_|\\__\\___/ \n";
*/
        String name = "Burrito";
        /*System.out.println(logo);*/
        System.out.println(lineseperator);
        System.out.println("Hello! I'm " + name + ".\nWhat can I do for you?");
        System.out.println(lineseperator);
        boolean exit = false;
        String input;
        boolean isCommand = false;

        Scanner scanner = new Scanner(System.in);

        while (!exit && scanner.hasNextLine()) {
            isCommand = false;

            input = scanner.nextLine();
            String inputArr[] = input.split(" ", 2);
            System.out.println(lineseperator);

            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equals(inputArr[0])) {
                    if (inputArr[0].equals("list")) {
                        list();
                        isCommand = true;

                    } else if (inputArr[0].equals("mark")) {
                        mark(inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("unmark")) {
                        unmark(inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("todo")) {
                        todo(inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("deadline")) {
                        deadline(inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("event")) {
                        event(inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("bye")) {
                        bye();
                        exit = true;
                        isCommand = true;
                    }

                } else {

                }
            }


            if (!isCommand){
                System.out.println("Not a valid command!");


            }
            System.out.println(lineseperator);




        }


    }
}


