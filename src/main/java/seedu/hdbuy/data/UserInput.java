package seedu.hdbuy.data;

import java.util.LinkedHashMap;

import seedu.hdbuy.common.QueryKey;

public class UserInput {

    private final LinkedHashMap<QueryKey, String> inputs;

    public UserInput() {
        this.inputs = new LinkedHashMap<>();
    }

    public LinkedHashMap<QueryKey, String> getInputs() {
        return inputs;
    }

    public void clearInputs() {
        inputs.clear();
    }
}
