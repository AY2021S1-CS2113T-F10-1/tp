package seedu.hdbuy.data.exception;

public class EmptyParameterException extends Exception {
    public EmptyParameterException() {
        super(" has no parameter for the app to search on.");
    }
}
