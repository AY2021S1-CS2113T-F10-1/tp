package seedu.hdbuy.common.exception;

public class EmptyResponseException extends Exception {

    public EmptyResponseException() {
        super("There are no flats matching your demands.");
    }
}
