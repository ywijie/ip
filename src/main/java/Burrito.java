import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Burrito {

    static List<Task> cache = new ArrayList<>();
    static String[] commands = {"bye", "list", "mark", "unmark", "todo", "deadline", "event", "delete"};
    static String lineseperator = "____________________________________________________________";
    static String home = System.getProperty("user.home");
    static String filePath = "src/main/java/data/";
    static String fileName = "save.txt";


    /**
     * Prints the contents of the Task List
     *
     * @return void.
     */
    static public void list() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < cache.size(); i++) {
            int tempi = i + 1;
            
            System.out.println(tempi + ". " + cache.get(i).toString());

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
        try {
            cache.add(new Todo(inputArr[1]));
            System.out.println("Got it. I've added this task:");
            System.out.println(cache.get(cache.size() - 1).toString());
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Todo description cannot be empty!");

        } finally {}

    }

    /**
     * Creates deadline task and adds it to cache
     *
     * @param inputArr User input
     * @return void.
     */
    static public void deadline(String[] inputArr) {
        try {
            String[] newInputArr = inputArr[1].split(" /by ", 2);
            String[] newInputArr2 = newInputArr[1].split(" ");
            newInputArr[1] = dateParser(newInputArr2[0]) + " " + timeParser(newInputArr2[1]);

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


        try {
            String[] newInputArr = inputArr[1].split(" /from ", 2);
            String[] newInputArr2 = newInputArr[1].split(" /to ", 2);

            String[] newInputArr3 = newInputArr2[0].split(" ");
            newInputArr2[0] = dateParser(newInputArr3[0]) + " " + timeParser(newInputArr3[1]);

            String[] newInputArr4 = newInputArr2[1].split(" ");
            newInputArr2[1] = dateParser(newInputArr4[0]) + " " + timeParser(newInputArr4[1]);

            cache.add(new Event(newInputArr[0], newInputArr2[0], newInputArr2[1]));
            System.out.println("Got it. I've added this task:");
            System.out.println(cache.get(cache.size() - 1).toString());
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Something went wrong, check your syntax! (seperate with \"/from\" and \"/to\"");

        } finally {}

    }

    /**
     * Deletes task from cache
     *
     * @param inputArr User input
     * @return void.
     */
    static public void delete(String[] inputArr) {
        try {
            System.out.println("Noted. I've removed this task:");
            System.out.println(cache.get(Integer.parseInt(inputArr[1]) - 1).toString());
            cache.remove(Integer.parseInt(inputArr[1]) - 1);
            System.out.println("Now you have " + cache.size() + " task(s) in the list.");

        } catch (Exception e) {
            System.out.println("Invalid index!");
        } finally {}
    }

    /**
     * Populates cache with entries from file
     *
     * @return void.
     */
    static public void initCache() {
        try {
            Files.createDirectories(Paths.get(filePath));
            File saveFile = new File(filePath + fileName);
            if (saveFile.createNewFile()) {
                System.out.println("Warning! Save file not found on Disk. Creating a new one now...");
            }
            Scanner myReader = new Scanner(saveFile);
            while (myReader.hasNextLine()) {
                boolean Done = false;
                String data = myReader.nextLine();
                if (data.charAt(1) == 'T') {
                    if (data.charAt(5) == 'X') {
                        Done = true;
                    }
                    cache.add(new Todo(data.substring(8)));
                    cache.get(cache.size() - 1).setStatus(Done);

                } else if (data.charAt(1) == 'D') {
                    if (data.charAt(5) == 'X') {
                        Done = true;
                    }
                    String[] newData = data.substring(8, data.length() - 1).split(" \\(by: ");
                    cache.add(new Deadline(newData[0], newData[1]));
                    cache.get(cache.size() - 1).setStatus(Done);

                } else if (data.charAt(1) == 'E') {
                    if (data.charAt(5) == 'X') {
                        Done = true;
                    }
                    String[] newData = data.substring(8, data.length() - 1).split(" \\(from: ");
                    String[] newData2 = newData[1].split(" to: ");

                    cache.add(new Event(newData[0], newData2[0], newData2[1]));
                    cache.get(cache.size() - 1).setStatus(Done);
                } else { }

            }

        } catch (Exception e) {
            System.out.println("Error initializing cache.");
            // System.out.println(e.getMessage());
        } finally { }
    }

    /**
     * Saves task list from cache to Hard Disk
     *
     * @return void.
     */
    static public void saveToDisk() {
        try {


            FileWriter fw = new FileWriter(filePath + fileName);
            for (Task task : cache) {
                fw.write(task.toString() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving to disk.");
        } finally {}
    }

    /**
     * Parses date from input string
     *
     * @param input User input in format "YYYY/MM/DD"
     * @return Reformatted date.
     */
    static public String dateParser(String input) {
        try {

            LocalDate d1 = LocalDate.parse(input.replace("/", "-"));

            return d1.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        } catch (Exception e) {
            System.out.println("Error! Wrong date formatting (Use YYYY-MM-DD, eg 2019-12-28).");
            return input;
        } finally { }
    }

    /**
     * Parses time from input string
     *
     * @param input User input in 24h format
     * @return Reformatted time in 12h format.
     */
    static public String timeParser(String input) {
        try {
            String _24HourTime = input.charAt(0) + input.charAt(1) + ":" + input.charAt(2) + input.charAt(3);
            SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
            SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
            Date _24HourDt = _24HourSDF.parse(_24HourTime);
            return _12HourSDF.format(_24HourDt);


        } catch (Exception e) {
            System.out.println("Error! Wrong time formatting (Use 24h format, eg: '1300' for 1pm).");
            return input;
        } finally { }
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

        initCache();

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

                    } else if (inputArr[0].equals("delete")) {
                        delete(inputArr);
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
            saveToDisk();
            System.out.println(lineseperator);




        }


    }
}


