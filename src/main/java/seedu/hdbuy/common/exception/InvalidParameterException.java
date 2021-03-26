package seedu.hdbuy.common.exception;

public class InvalidParameterException extends Exception {
    public InvalidParameterException() {
        super("You must enter the correct number of parameters.");
    }
}
