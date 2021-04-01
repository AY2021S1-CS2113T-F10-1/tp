package seedu.hdbuy.common;

public class CommandKey {

    private final String criteria;
    private final String value;
    private final String command;

    public CommandKey(String criteria, String value, String command) {
        this.criteria = criteria;
        this.value = value;
        this.command = command;
    }

    public CommandKey(String criteria, String command) {
        this.criteria = criteria;
        this.command = command;
        this.value = null;
    }
    
    public CommandKey(String command) {
        this.command = command;
        this.value = "";
        this.criteria = "";
    }

    public CommandKey(String command, String value) {
        this.command = command;
        this.value = value;
        this.criteria = "";
    }

    public String getCriteria() {
        return criteria;
    }

    public String getValue() {
        return value;
    }

    public String getCommand() {
        return command;
    }
}
