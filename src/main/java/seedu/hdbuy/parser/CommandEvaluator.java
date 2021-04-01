package seedu.hdbuy.parser;

import java.util.Arrays;
import java.util.logging.Logger;

import seedu.hdbuy.common.CommandKey;
import seedu.hdbuy.common.exception.InvalidParameterException;

public class CommandEvaluator {

    public static CommandKey extractInfo(String fullLine) throws InvalidParameterException {
        String[] lineParts;
        lineParts = fullLine.split(" ");
        Logger.getLogger("Parser").info(Arrays.toString(lineParts));
        String keyCommand = lineParts[0];
        switch (keyCommand) {
        case CommandType.FILTER:
            if (lineParts.length < 3) {
                throw new InvalidParameterException(keyCommand);
            }
            String filterCriteria = lineParts[1];
            String filterValue = String.join(" ",
                Arrays.asList(lineParts).subList(2, lineParts.length));
            return new CommandKey(filterCriteria, filterValue, keyCommand);
        case CommandType.SORT:
            if (lineParts.length == 2) {
                String sortValue = lineParts[1];
                if (sortValue.equals(CommandType.SORT_ASC) || sortValue.equals(CommandType.SORT_DESC)) {
                    return new CommandKey(keyCommand, sortValue);
                }
            }
            throw new InvalidParameterException(keyCommand);
        case CommandType.REMOVE:
        case CommandType.SAVE:
            if (lineParts.length != 2) {
                throw new InvalidParameterException(keyCommand);
            }
            String saveValue = lineParts[1];
            return new CommandKey(keyCommand, saveValue);
        default:
            // any other commands
            if (lineParts.length != 1) {
                throw new InvalidParameterException(keyCommand);
            }
        }
        return new CommandKey(keyCommand);
    }
}
