package seedu.hdbuy.common.exception;

public class GatewayException extends Exception {

    public GatewayException() {
        super("Server seems to be down, or was it your Internet connection?");
    }
}
