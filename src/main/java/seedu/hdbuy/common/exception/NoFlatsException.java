package seedu.hdbuy.common.exception;

public class NoFlatsException extends Exception {
    public NoFlatsException() {
        super("Please choose another filter.");
    }
}
