package seedu.hdbuy.common.exception;

public class InvalidParameterException extends Exception {
    private final String keyCommand;

    public InvalidParameterException(String keyCommand) {
        super("You must enter the correct number of parameters.");
        this.keyCommand = keyCommand;
    }

    public String getKeyCommand() {
        return keyCommand;
    }
}
