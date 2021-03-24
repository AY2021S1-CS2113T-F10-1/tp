package seedu.hdbuy.ui;

import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.exception.EmptyParameterException;
import seedu.hdbuy.data.exception.InvalidFilterException;
import seedu.hdbuy.data.exception.InvalidParameterException;

import java.util.HashMap;
import java.util.Scanner;

public class TextUi {

    /**
     * Number of dashes for the separator.
     */
    private static final int SEPARATOR_LENGTH = 80;
    private static final Scanner in = new Scanner(System.in);

    public static void showSeparator() {
        for (int i = 0; i < SEPARATOR_LENGTH; i++) {
            System.out.print('-');
        }
        System.out.print('\n');
    }

    public static void showWelcome() {
        showSeparator();
        System.out.print("Welcome to HDBuy!\nHow may I help you today?\n");
        showSeparator();
    }

    public static void showExit() {
        System.out.print("HDBuy Bye Bye!\n");
        in.close();
    }

    public static String readCommand() {
        return in.nextLine();
    }

    public static void showInvalidInput(String input) {
        System.out.print("I'm sorry. \"" + input + "\" is not a valid command.\n");
    }

    public static void showHelp() {
        System.out.print("*HELP PLACEHOLDER*\n");
    }

    public static void showParameters(HashMap<QueryKey, String> inputs) {
        System.out.print("Parameters:\n" + inputs + "\n");
    }

    public static void showInvalidFilter(String criteria, InvalidFilterException e) {
        System.out.println("\"" + criteria + "\" " + e.getMessage());
    }

    public static void showInvalidParameter(InvalidParameterException e) {
        System.out.println(e.getMessage());
    }

    public static void showEmptyParameter(String key, EmptyParameterException e) {
        System.out.println("\"" + key + "\"" + e.getMessage());
    }
}
