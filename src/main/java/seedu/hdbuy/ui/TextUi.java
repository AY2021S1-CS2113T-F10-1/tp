package seedu.hdbuy.ui;

import seedu.hdbuy.data.QueryKey;

import java.util.HashMap;
import java.util.Scanner;

public class TextUi {

    /** Number of dashes for the separator. */
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

    public static void showInvalidFilter(String criteria) {
        System.out.print("\"" + criteria + "\" is not a valid filter.\n");
    }

    public static void showInvalidParameter() {
        System.out.println("You must enter at least 1 more parameter.");
    }
}
