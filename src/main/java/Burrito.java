import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Burrito {

    static List<Task> cache = new ArrayList<>();
    static String[] commands = {"bye", "list", "mark", "unmark"};
    static String lineseperator = "____________________________________________________________";


    /**
     * Creates a Task object with description and stores it in the Task List
     *
     * @param text the description of the Task object
     * @return The text to be printed.
     */
    static public String addToCache(String text) {
        cache.add(new Task(text));
        return "added: " + text;

    }

    /**
     * Prints the contents of the Task List
     *
     * @return void.
     */
    static public void list() {
        for (int i = 0; i < cache.size(); i++) {
            int tempi = i + 1;
            System.out.println(tempi + ". [" + cache.get(i).getStatusIcon() + "] " + cache.get(i).getDescription());

        }


    }

    public static void main(String[] args) {
        String logo = " ____                      _        \n"
                + "|  _ \\                  (_) |       \n"
                + "| |_) |  _   _ _ __ _ __ _| |_ ___  \n"
                + "|  _ <  | | | | .--| .--| | __/   \\ \n"
                + "| |_) | | |_| | |  | |  | | || (_) |\n"
                + "|____/   \\__,_|_|  |_|  |_|\\__\\___/ \n";

        String name = "Burrito";
        System.out.println(logo);
        System.out.println(lineseperator);
        System.out.println("Hello! I'm " + name + ".\nWhat can I do for you?");
        System.out.println(lineseperator);
        boolean exit = false;
        String input;
        boolean isCommand = false;


        while (!exit) {
            isCommand = false;
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            String inputArr[] = input.split(" ", 2);
            System.out.println(lineseperator);

            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equals(inputArr[0])) {
                    if (inputArr[0].equals("list")) {
                        list();
                        isCommand = true;
                    } else if (inputArr[0].equals("mark")) {
                        if (inputArr.length <= 1) {
                            System.out.println("Sorry! you didn't specify the index.");
                        } else {
                            try {
                                cache.get(Integer.parseInt(inputArr[1]) - 1).setStatus(true);
                                System.out.println("Nice! I've marked this task as done.");
                                System.out.println("[" + cache.get(Integer.parseInt(inputArr[1]) - 1).getStatusIcon() + "] "
                                        + cache.get(Integer.parseInt(inputArr[1]) - 1).getDescription());

                            } catch (Exception e) {
                                System.out.println("Wrong formatting for index!");
                            } finally { }
                        }
                        isCommand = true;


                    } else if (inputArr[0].equals("unmark")) {
                        if (inputArr.length <= 1) {
                            System.out.println("Sorry! you didn't specify the index.");
                        } else {
                            try {
                                cache.get(Integer.parseInt(inputArr[1]) - 1).setStatus(false);
                                System.out.println("Nice! I've marked this task as not done yet.");
                                System.out.println("[" + cache.get(Integer.parseInt(inputArr[1]) - 1).getStatusIcon() + "] "
                                        + cache.get(Integer.parseInt(inputArr[1]) - 1).getDescription());

                            } catch (Exception e) {
                                System.out.println("Wrong formatting for index!" + e.getMessage());
                            } finally {
                            }
                        }
                        isCommand = true;





                    } else if (inputArr[0].equals("bye")) {
                        System.out.println("Bye. Hope to see you again soon!");

                        exit = true;
                        isCommand = true;
                    }

                } else {

                }
            }


            if (!isCommand){
                System.out.println(addToCache(input));

            }
            System.out.println(lineseperator);





        }


    }
}


