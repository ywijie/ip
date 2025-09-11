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




    }
}


