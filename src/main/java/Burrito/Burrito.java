package Burrito;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import Burrito.TaskList.*;
import Burrito.UI.TextUI;
import Burrito.Parser.Parser;
import Burrito.Storage.Storage;

public class Burrito {

    static List<Task> cache = new ArrayList<>();
    private static final String lineseperator = "____________________________________________________________";
    static String[] commands = {"bye", "list", "mark", "unmark", "todo", "deadline", "event", "delete"};


    static TextUI TextUI;
    static TaskList TaskList;
    static Storage storage;
    static Parser parser;

    public static void main(String[] args) {

        TextUI = new TextUI();
        storage = new Storage();
        parser = new Parser();

        boolean exit = false;
        String input;
        boolean isCommand = false;

        cache = storage.initCache();

        TextUI.welcome();
        Scanner scanner = new Scanner(System.in);

        while (!exit && scanner.hasNextLine()) {
            isCommand = false;

            input = scanner.nextLine();
            String inputArr[] = input.split(" ", 2);
            System.out.println(lineseperator);

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
                        exit = true;
                        isCommand = true;
                    }

                } else {

                }
            }


            if (!isCommand){
                System.out.println("Not a valid command!");


            }
            storage.saveToDisk();
            System.out.println(lineseperator);




        }


    }
}


