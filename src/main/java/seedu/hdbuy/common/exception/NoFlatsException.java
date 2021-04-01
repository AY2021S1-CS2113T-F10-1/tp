package seedu.hdbuy.common.exception;

public class NoFlatsException extends Exception {
    public NoFlatsException() {
        super("There are no flats to be shown.");
    }
}
