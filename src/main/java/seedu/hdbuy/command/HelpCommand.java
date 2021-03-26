package seedu.hdbuy.command;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;

public class HelpCommand extends Command {
    @Override public void execute(UserInput userInput) {
        TextUi.showHelp();
    }
}
