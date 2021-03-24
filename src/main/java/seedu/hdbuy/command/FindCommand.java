package seedu.hdbuy.command;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.EmptyParameterException;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;

public class FindCommand extends Command {

    @Override public void execute(HashMap<QueryKey, String> inputs) {
        try {
            if (inputs.isEmpty()) {
                throw new EmptyParameterException();
            } else {
                TextUi.showParameters(inputs);
                HashMap<Integer, Unit> units = ApiRepository.fetchUnits(inputs);
            }
        } catch (EmptyParameterException e) {
            TextUi.showEmptyParameter("FIND", e);
        }
    }
}
