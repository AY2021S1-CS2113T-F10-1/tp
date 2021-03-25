package seedu.hdbuy.command;

import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.InvalidFilterException;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;

public class FilterCommand extends Command {

    protected String criteria;
    protected String value;

    public FilterCommand(String criteria, String value) {
        this.criteria = criteria;
        this.value = value;
    }

    @Override public void execute(HashMap<QueryKey, String> inputs) {
        try {
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
