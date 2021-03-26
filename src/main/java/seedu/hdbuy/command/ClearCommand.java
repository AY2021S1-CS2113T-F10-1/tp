package seedu.hdbuy.command;

import java.util.HashMap;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

public class ClearCommand extends Command {

    @Override public void execute(UserInput userInputs) {
        userInputs.clearInputs();
        TextUi.showClearedFilterConditions();
    }
}
