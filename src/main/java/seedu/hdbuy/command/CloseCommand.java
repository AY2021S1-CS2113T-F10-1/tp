package seedu.hdbuy.command;

import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

public class CloseCommand extends Command {

    @Override public void execute(UserInput inputs) {
        TextUi.showExit();
    }
}
