import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Burrito {

    static List<String> cache = new ArrayList<>();
    static String[] commands = {"bye", "list"};
    static String lineseperator = "____________________________________________________________";



    static public String addToCache(String text) {
        cache.add(text);
        return "added: " + text;

    }

    static public void list() {
        for (int i = 0; i < cache.size(); i++) {
            int tempi = i + 1;
            System.out.println(tempi + ". " + cache.get(i));

        }


    }

    public void echo() {

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
            System.out.println(lineseperator);

            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equals(input)) {
                    if (input.equals("list")) {
                        list();
                        isCommand = true;
                    }
                    if (input.equals("bye")) {
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


