package seedu.hdbuy.command;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.data.UserInput;

import java.util.HashMap;

public abstract class Command {

    public abstract void execute(UserInput userInput);

    public boolean isExit() {
        return this instanceof CloseCommand;
    }
}
