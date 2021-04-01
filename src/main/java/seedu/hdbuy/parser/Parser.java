package seedu.hdbuy.parser;

import org.junit.Assert;

import java.util.logging.Logger;

import seedu.hdbuy.command.ClearCommand;
import seedu.hdbuy.command.CloseCommand;
import seedu.hdbuy.command.Command;
import seedu.hdbuy.command.DefaultCommand;
import seedu.hdbuy.command.FilterCommand;
import seedu.hdbuy.command.FindCommand;
import seedu.hdbuy.command.HelpCommand;
import seedu.hdbuy.command.ListCommand;
import seedu.hdbuy.command.RemoveCommand;
import seedu.hdbuy.command.SaveCommand;
import seedu.hdbuy.command.ShortlistCommand;
import seedu.hdbuy.command.SortCommand;
import seedu.hdbuy.common.CommandKey;
import seedu.hdbuy.common.exception.InvalidParameterException;
import seedu.hdbuy.ui.TextUi;

public class Parser {

    public static Command parse(String fullLine) {
        Command command = new DefaultCommand(fullLine);
        Assert.assertNotNull(command);
        try {
            CommandKey keyCommand = CommandEvaluator.extractInfo(fullLine);
            switch (keyCommand.getCommand()) {
            case CommandType.HELP:
                command = new HelpCommand();
                break;
            case CommandType.FILTER:
                String criteria = keyCommand.getCriteria();
                String value = keyCommand.getValue();
                command = new FilterCommand(criteria, value);
                break;
            case CommandType.FIND:
                command = new FindCommand();
                break;
            case CommandType.EXIT:
                command = new CloseCommand();
                break;
            case CommandType.CLEAR:
                command = new ClearCommand();
                break;
            case CommandType.LIST:
                command = new ListCommand();
                break;
            case CommandType.SHORTLIST:
                command = new ShortlistCommand();
                break;
            case CommandType.SAVE:
                int addIndex = Integer.parseInt(keyCommand.getValue());
                command = new SaveCommand(addIndex);
                break;
            case CommandType.REMOVE:
                int removeIndex = Integer.parseInt(keyCommand.getValue());
                command = new RemoveCommand(removeIndex);
                break;
            case CommandType.SORT:
                String sortCriteria = keyCommand.getValue();
                command = new SortCommand(sortCriteria);
                break;
            default:
                TextUi.showInvalidInput(keyCommand.getCommand());
                break;
            }
        } catch (InvalidParameterException e) {
            Logger.getLogger("Parser").severe(e.getMessage());
            TextUi.showInvalidParameter(e.getKeyCommand(), e);
        } catch (NumberFormatException e) {
            Logger.getLogger("Parser").severe(e.getMessage());
            TextUi.showInvalidIndex();
        }
        return command;
    }
}
