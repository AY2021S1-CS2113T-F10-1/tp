package seedu.hdbuy.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.common.Unit;
import seedu.hdbuy.common.exception.EmptyParameterException;
import seedu.hdbuy.common.exception.InvalidFilterException;
import seedu.hdbuy.common.exception.InvalidParameterException;
import seedu.hdbuy.common.exception.InvalidSortException;
import seedu.hdbuy.common.exception.NoFlatsException;

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
        System.out.println("Type \"help\" for more information.");
    }

    public static void showHelp() {
        System.out.print("HdBuy is a way to easily find and bookmark resale flats of your liking.\n\n"
                + "Report bugs to: hdbuy@gmail.com\n"
                + "GitHub page: <https://github.com/AY2021S2-CS2113-F10-1/tp>\n"
                + "User Guide: <https://github.com/AY2021S2-CS2113-F10-1/tp/blob/master/docs/UserGuide.md>\n\n"
                + "Available commands:\n"
                + "\tfilter <attribute> <value>\t\tAdd a filter condition. eg: filter location woodlands\n"
                + "\tlist\t\t\t\t\t\t\tShow all currently set filter condition to filter units matching preferences.\n"
                + "\tclear\t\t\t\t\t\t\tRemove all currently set filter conditions.\n"
                + "\tfind\t\t\t\t\t\t\tSearch for units with the current filter conditions.\n"
                + "\tsort <direction>\t\t\t\tSort search results in ascending(asc) or descending(desc) order.\n"
                + "\tsave <index>\t\t\t\t\tAdd the unit at the inputted index to the shortlist.\n"
                + "\tremove <index>\t\t\t\t\tRemove the unit at the inpuuted index from the shortlist.\n"
                + "\tshortlist\t\t\t\t\t\tShow all units in the shortlist.\n"
                + "\tbye\t\t\t\t\t\t\t\tExit the application\n"
        );
    }

    public static void showParameters(LinkedHashMap<QueryKey, String> inputs) {
        if (inputs.isEmpty()) {
            System.out.println("Currently there are no filter conditions set.");
            return;
        }
        System.out.print("Filter conditions:\n" + inputs + "\n");
    }

    public static void showInvalidFilter(String criteria, InvalidFilterException e) {
        System.out.println("\"" + criteria + "\" " + e.getMessage());
        System.out.println("Please use these filters: " + Arrays.asList(QueryKey.values()));
    }

    public static void showInvalidIndex() {
        System.out.println("Index is invalid");
    }

    public static void showRemovedShortlistUnit(String unitDescription) {
        System.out.println("You have removed unit from shortlist: " + unitDescription);
    }

    public static void showSavedShortlistUnit(String unitDescription) {
        System.out.println("You have saved unit to shortlist: " + unitDescription);
    }

    public static void showInvalidParameter(String key, InvalidParameterException e) {
        System.out.println(e.getMessage());
        switch (key) {
        case "filter":
            System.out.println("FILTER command needs a type and a parameter to work.");
            System.out.println("Filter types: " + Arrays.asList(QueryKey.values()));
            System.out.println("Example: \"filter location clementi\"");
            break;
        case "find":
            System.out.println("FIND command does not need any parameters.");
            System.out.println("However, you need to provide filter before you execute the FIND command.");
            break;
        default:
            break;
        }
    }

    public static void showUnits(ArrayList<Unit> units) {
        Object[] columnNames = {"Index", "Address", "Type", "Lease", "Price"};
        System.out.format("%5s%24s%12s%24s%12s\n", columnNames);
        int i = 0;
        for (Unit unit : units) {
            Object[] unitData = {++i, unit.getAddress(), unit.getType(),
                    unit.getLease(), "$" + unit.getPrice()};
            System.out.format("%5s%24s%12s%24s%12s\n", unitData);
        }
    }

    public static void showShortListUnits(ArrayList<Unit> units) {
        Object[] columnNames = {"Index", "Address", "Type", "Lease", "Price"};
        System.out.format("%5s%24s%12s%24s%12s\n", columnNames);
        int i = 0;
        for (Unit unit : units) {
            Object[] unitData = {++i, unit.getAddress(), unit.getType(),
                    unit.getLease(), "$" + unit.getPrice()};
            System.out.format("%5s%24s%12s%24s%12s\n", unitData);
        }
    }

    public static void showNoFlats(NoFlatsException e) {
        System.out.println(e.getMessage());
    }

    public static void showEmptyParameter(String key, EmptyParameterException e) {
        System.out.println("\"" + key + "\"" + e.getMessage());
        System.out.println("Please specified a filter to use before executing this command.");
        System.out.println("Filters included: " + Arrays.asList(QueryKey.values()));
        System.out.println("An example will be \"filter location clementi\"");
    }

    public static void showClearedFilterConditions() {
        System.out.print("Cleared filter conditions.\n");
    }

    public static void showInvalidSort(String criteria, InvalidSortException e) {
        System.out.println(criteria + e.getMessage());
    }
}
