package seedu.hdbuy.command;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.data.UserInput;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClearCommandTest {

    @Test void execute() {
        UserInput testInput = new UserInput();
        LinkedHashMap<QueryKey, String> inputs = testInput.getInputs();
        inputs.put(QueryKey.LOCATION, "ang mo kio");
        inputs.put(QueryKey.TYPE, "4 room");
        inputs.put(QueryKey.LEASE_REMAINING, "80");
        assertFalse(testInput.getInputs().isEmpty());
        ClearCommand clearCommand = new ClearCommand();
        clearCommand.execute(testInput);
        assertTrue(testInput.getInputs().isEmpty());
    }
}