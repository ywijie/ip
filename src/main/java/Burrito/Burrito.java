package burrito;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

<<<<<<< HEAD:src/main/java/Burrito/Burrito.java
import burrito.TaskList.*;
import burrito.UI.TextUI;
import burrito.Parser.Parser;
import burrito.Storage.Storage;
=======
import burrito.tasklist.*;
import burrito.ui.TextUI;
import burrito.parser.Parser;
import burrito.storage.Storage;
>>>>>>> branch-A-CodingStandard:src/main/java/burrito/Burrito.java

public class Burrito {

    static List<Task> cache = new ArrayList<>();
    private static final String lineSeperator = "____________________________________________________________";
    static String[] commands = {"bye", "list", "mark", "unmark", "todo", "deadline", "event", "delete"};


    static TextUI TextUI;
    static TaskList TaskList;
    static Storage storage;
    static Parser parser;

    public static void main(String[] args) {

        TextUI = new TextUI();
        storage = new Storage();
        parser = new Parser();

        boolean isDone = false;
        String input;
        boolean isCommand = false;

        cache = storage.initCache();

        TextUI.welcome();
        Scanner scanner = new Scanner(System.in);

        while (!isDone && scanner.hasNextLine()) {
            isCommand = false;

            input = scanner.nextLine();
            String inputArr[] = input.split(" ", 2);
            System.out.println(lineSeperator);

            for (int i = 0; i < commands.length; i++) {
                if (commands[i].equals(inputArr[0])) {
                    if (inputArr[0].equals("list")) {
                        TextUI.list(cache);
                        isCommand = true;

                    } else if (inputArr[0].equals("mark")) {
                        cache = TaskList.mark(cache, inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("unmark")) {
                        cache = TaskList.unmark(cache, inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("todo")) {
                        cache = TaskList.todo(cache, inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("deadline")) {
                        cache = TaskList.deadline(cache, inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("event")) {
                        cache = TaskList.event(cache, inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("delete")) {
                        cache = TaskList.delete(cache, inputArr);
                        isCommand = true;

                    } else if (inputArr[0].equals("bye")) {
                        TextUI.bye();
                        isDone = true;
                        isCommand = true;
                    }

                } else {

                }
            }


            if (!isCommand){
                System.out.println("Not a valid command!");


            }
            storage.saveToDisk();
            System.out.println(lineSeperator);




        }


    }
}


