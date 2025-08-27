package burrito.tasklist;

import burrito.parser.Parser;
import java.util.List;

public class TaskList {

    public TaskList(){}

    /**
     * Marks task as done
     *
     * @param inputArr User input
     * @param cache List of tasks
     * @return List<Task> cache.
     */
    static public List<Task> mark(List<Task> cache, String[] inputArr) {
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
        return cache;

    }

    /**
     * Marks task as undone
     *
     * @param inputArr User input
     * @param cache List of tasks
     * @return List<Task> cache.
     */
    static public List<Task> unmark(List<Task> cache, String[] inputArr) {
        if (inputArr.length <= 1) {
            System.out.println("Sorry! you didn't specify the index.");
        } else {
            try {
                cache.get(Integer.parseInt(inputArr[1]) - 1).setStatus(false);
                System.out.println("Nice! I've marked this task as not done yet.");
                System.out.println(cache.get(Integer.parseInt(inputArr[1]) - 1).toString());


            } catch (Exception e) {
                System.out.println("Wrong formatting for index!" + e.getMessage());
            } finally { }

        }
        return cache;
    }

    /**
     * Creates todo task and adds it to cache
     *
     * @param inputArr User input
     * @param cache List of tasks
     * @return List<Task> cache.
     */
    static public List<Task> todo(List<Task> cache, String[] inputArr) {
        try {
            cache.add(new Todo(inputArr[1]));
            System.out.println("Got it. I've added this task:");
            System.out.println(cache.get(cache.size() - 1).toString());
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Todo description cannot be empty!");

        } finally {}
        return cache;

    }

    /**
     * Creates deadline task and adds it to cache
     *
     * @param inputArr User input
     * @param cache List of tasks
     * @return List<Task> cache.
     */
    static public List<Task> deadline(List<Task> cache, String[] inputArr) {
        try {
            String[] newInputArr = inputArr[1].split(" /by ", 2);
            String[] newInputArr2 = newInputArr[1].split(" ");
            newInputArr[1] = Parser.dateParser(newInputArr2[0]) + " " + Parser.timeParser(newInputArr2[1]);

            cache.add(new Deadline(newInputArr[0], newInputArr[1]));
            System.out.println("Got it. I've added this task:");
            System.out.println(cache.get(cache.size() - 1).toString());
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Something went wrong, check your syntax! (seperate with \"/by\"");

        } finally {}
        return cache;

    }

    /**
     * Creates event task and adds it to cache
     *
     * @param inputArr User input
     * @param cache List of tasks
     * @return List<Task> cache.
     */
    static public List<Task> event(List<Task> cache, String[] inputArr) {


        try {
            String[] newInputArr = inputArr[1].split(" /from ", 2);
            String[] newInputArr2 = newInputArr[1].split(" /to ", 2);

            String[] newInputArr3 = newInputArr2[0].split(" ");
            newInputArr2[0] = Parser.dateParser(newInputArr3[0]) + " " + Parser.timeParser(newInputArr3[1]);

            String[] newInputArr4 = newInputArr2[1].split(" ");
            newInputArr2[1] = Parser.dateParser(newInputArr4[0]) + " " + Parser.timeParser(newInputArr4[1]);

            cache.add(new Event(newInputArr[0], newInputArr2[0], newInputArr2[1]));
            System.out.println("Got it. I've added this task:");
            System.out.println(cache.get(cache.size() - 1).toString());
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Something went wrong, check your syntax! (seperate with \"/from\" and \"/to\"");

        } finally {}
        return cache;

    }

    /**
     * Deletes task from cache
     *
     * @param inputArr User input
     * @param cache List of tasks
     * @return List<Task> cache.
     */
    static public List<Task> delete(List<Task> cache, String[] inputArr) {
        try {
            System.out.println("Noted. I've removed this task:");
            System.out.println(cache.get(Integer.parseInt(inputArr[1]) - 1).toString());
            cache.remove(Integer.parseInt(inputArr[1]) - 1);
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Invalid index!");
        } finally {}
        return cache;
    }

}
