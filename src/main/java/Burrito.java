import java.util.Scanner;

public class Burrito {
    public static void main(String[] args) {
        String logo = " ____                      _        \n"
                + "|  _ \\                  (_) |       \n"
                + "| |_) |  _   _ _ __ _ __ _| |_ ___  \n"
                + "|  _ <  | | | | .--| .--| | __/   \\ \n"
                + "| |_) | | |_| | |  | |  | | || (_) |\n"
                + "|____/   \\__,_|_|  |_|  |_|\\__\\___/ \n";

        String name = "Burrito";
        String lineseperator = "____________________________________________________________";
        System.out.println(logo);
        System.out.println(lineseperator);
        System.out.println("Hello! I'm " + name + ".\nWhat can I do for you?");
        System.out.println(lineseperator);
        boolean exit = true;
        String input;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            System.out.println(lineseperator);

            if (input.equals("bye")) {
                exit = false;
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(lineseperator);

                break;
            }
            System.out.println(input);
            System.out.println(lineseperator);





        }


    }
}


