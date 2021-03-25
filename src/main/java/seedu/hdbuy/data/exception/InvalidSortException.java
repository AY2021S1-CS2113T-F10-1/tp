package seedu.hdbuy.data.exception;

public class InvalidSortException extends Exception {
    public InvalidSortException() {
        super("is not a valid sort. Please enter either asc or desc");
    }
}
