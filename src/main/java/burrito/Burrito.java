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
    static String[] commands = {"bye", "help", "list", "mark", "unmark", "todo", "deadline", "event", "delete", "find"};


    static TextUI textUI;
    static TaskList taskList;
    static Storage storage;
    static Parser parser;

    public String getResponse(String input) {
        String[] inputArr = input.split(" ", 2);

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals(inputArr[0])) {
                switch (inputArr[0]) {
                case "list" -> {
                    return TextUI.list(cache);
                }
                case "mark" -> {
                    return TaskList.mark(cache, inputArr);
                }
                case "unmark" -> {
                    return TaskList.unmark(cache, inputArr);
                }
                case "todo" -> {
                    return TaskList.todo(cache, inputArr);
                }
                case "deadline" -> {
                    return TaskList.deadline(cache, inputArr);
                }
                case "event" -> {
                    return TaskList.event(cache, inputArr);
                }
                case "delete" -> {
                    return TaskList.delete(cache, inputArr);
                }
                case "find" -> {
                    return TaskList.find(cache, inputArr);
                }
                case "bye" -> {
                    return TextUI.bye();
                }
                case "help" -> {
                    return TextUI.help();
                }
                }

            } else { }
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


