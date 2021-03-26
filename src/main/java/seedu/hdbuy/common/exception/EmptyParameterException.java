package seedu.hdbuy.common.exception;

public class EmptyParameterException extends Exception {
    public EmptyParameterException() {
        super(" has no parameters currently.");
    }
}
