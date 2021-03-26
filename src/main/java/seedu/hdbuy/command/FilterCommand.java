package seedu.hdbuy.command;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.common.exception.InvalidFilterException;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;

public class FilterCommand extends Command {

    protected String criteria;
    protected String value;

    public FilterCommand(String criteria, String value) {
        this.criteria = criteria;
        this.value = value;
    }

    @Override public void execute(UserInput userInput) {
        try {
            HashMap<QueryKey, String> inputs = userInput.getInputs();
            switch (criteria) {
            case "location":
                inputs.put(QueryKey.LOCATION, value);
                break;
            case "type":
                inputs.put(QueryKey.TYPE, value);
                break;
            case "lease_remaining":
                inputs.put(QueryKey.LEASE_REMAINING, value);
                break;
            default:
                throw new InvalidFilterException();
            }
            TextUi.showParameters(inputs);
        } catch (InvalidFilterException e) {
            TextUi.showInvalidFilter(criteria, e);
        }
    }
}
