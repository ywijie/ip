package burrito;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import burrito.tasklist.*;
import burrito.ui.TextUI;
import burrito.parser.Parser;
import burrito.storage.Storage;

public class Burrito {

    static List<Task> cache = new ArrayList<>();
    private static final String lineSeperator = "____________________________________________________________";
    static String[] commands = {"bye", "list", "mark", "unmark", "todo", "deadline", "event", "delete", "find"};


    static TextUI textUI;
    static TaskList taskList;
    static Storage storage;
    static Parser parser;

    public String getResponse(String input) {
        String inputArr[] = input.split(" ", 2);

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(inputArr[0])) {
                if (inputArr[0].equals("list")) {
                    return TextUI.list(cache);

                } else if (inputArr[0].equals("mark")) {
                    return TaskList.mark(cache, inputArr);


                } else if (inputArr[0].equals("unmark")) {
                    return TaskList.unmark(cache, inputArr);

                } else if (inputArr[0].equals("todo")) {
                    return TaskList.todo(cache, inputArr);

                } else if (inputArr[0].equals("deadline")) {
                    return TaskList.deadline(cache, inputArr);

                } else if (inputArr[0].equals("event")) {
                    return TaskList.event(cache, inputArr);

                } else if (inputArr[0].equals("delete")) {
                    return TaskList.delete(cache, inputArr);

                } else if (inputArr[0].equals("find")) {
                    return TaskList.find(cache, inputArr);

                } else if (inputArr[0].equals("bye")) {
                    return TextUI.bye();

                }

            } else {

            }
        }
        return "Not a valid command!";


    }

    public Burrito() {
        textUI = new TextUI();
        storage = new Storage();
        parser = new Parser();

        cache = storage.initializeCache();
    }

    public static void main(String[] args) {

        /*TextUI = new TextUI();
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

                    } else if (inputArr[0].equals("find")) {
                        TaskList.find(cache, inputArr);
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
            storage.saveToDisk(cache);
            System.out.println(lineSeperator);




        }*/


    }
}


