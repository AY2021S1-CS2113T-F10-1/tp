package seedu.hdbuy.parser;

import seedu.hdbuy.command.CloseCommand;
import seedu.hdbuy.command.Command;
import seedu.hdbuy.command.DefaultCommand;
import seedu.hdbuy.command.FilterCommand;
import seedu.hdbuy.command.FindCommand;
import seedu.hdbuy.command.HelpCommand;
import seedu.hdbuy.command.SortCommand;
import seedu.hdbuy.data.CommandKey;
import seedu.hdbuy.data.exception.InvalidParameterException;
import seedu.hdbuy.ui.TextUi;

import java.util.Arrays;

public class Parser {
    private static final String HELP = "help";
    private static final String FILTER = "filter";
    private static final String FIND = "find";
    private static final String EXIT = "exit";
    private static final String SORT = "sort";

    public static Command parse(String fullLine) {
        Command command = new DefaultCommand(fullLine);
        try {
            CommandKey keyCommand = extractInfo(fullLine);
            switch (keyCommand.getCommand()) {
            case HELP:
                command = new HelpCommand();
                break;
            case FILTER:
                String criteria = keyCommand.getCriteria();
                String value = keyCommand.getValue();
                command = new FilterCommand(criteria, value);
                break;
            case SORT:
                String sortCriteria = keyCommand.getCriteria();
                command = new SortCommand(sortCriteria);
                break;
            case FIND:
                command = new FindCommand();
                break;
            case EXIT:
                command = new CloseCommand();
                break;
            default:
                break;
            }
        } catch (InvalidParameterException e) {
            TextUi.showInvalidParameter(e);
        } finally {
            return command;
        }
    }

    public static CommandKey extractInfo(String fullLine) throws InvalidParameterException {
        String[] lineParts;
        lineParts = fullLine.split(" ");
        String keyCommand = lineParts[0];
        switch (keyCommand) {
        case FILTER:
            if (lineParts.length < 3) {
                throw new InvalidParameterException();
            } else {
                String criteria = lineParts[1];
                String value = String.join(" ", Arrays.asList(lineParts).subList(2, lineParts.length));
                return new CommandKey(criteria, value, keyCommand);
            }
        case SORT:
            if (lineParts.length < 2) {
                throw new InvalidParameterException();
            } else {
                String criteria = lineParts[1];
                return new CommandKey(criteria, keyCommand);
            }
        case FIND:
            if (lineParts.length != 1) {
                throw new InvalidParameterException();
            }
            break;
        case EXIT:
            // Fallthrough
        case HELP:
            // Fallthrough
        default:
            break;
        }
        return new CommandKey(keyCommand);
    }
}
