package seedu.hdbuy.command;

import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

public class ClearCommand extends Command {

    @Override public void execute(UserInput userInputs) {
        userInputs.clearInputs();
        TextUi.showClearedFilterConditions();
    }
}
