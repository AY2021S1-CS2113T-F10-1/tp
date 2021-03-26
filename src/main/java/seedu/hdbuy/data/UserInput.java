package seedu.hdbuy.data;

import java.util.HashMap;

import seedu.hdbuy.common.QueryKey;

public class UserInput {

    private final HashMap<QueryKey, String> inputs;


    public UserInput() {
        this.inputs = new HashMap<>();
    }

    public HashMap<QueryKey, String> getInputs() {
        return inputs;
    }

    public void clearInputs() {
        inputs.clear();
    }
}
