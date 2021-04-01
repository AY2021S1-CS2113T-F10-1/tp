package seedu.hdbuy.command;

import seedu.hdbuy.data.UserInput;

public abstract class Command {

    public abstract void execute(UserInput userInput);

    public boolean isExit() {
        return this instanceof CloseCommand;
    }
}
