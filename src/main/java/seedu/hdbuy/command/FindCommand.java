package seedu.hdbuy.command;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.common.Unit;
import seedu.hdbuy.common.exception.EmptyParameterException;
import seedu.hdbuy.common.exception.NoFlatsException;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;
import java.util.logging.Logger;

public class FindCommand extends Command {

    private static final Logger logger = Logger.getLogger("FindCommand");

    @Override public void execute(UserInput userInput) {
        try {
            HashMap<QueryKey, String> inputs = userInput.getInputs();
            if (inputs.isEmpty()) {
                logger.warning("Unable to execute find command due to an empty filter");
                throw new EmptyParameterException();
            } else {
                TextUi.showParameters(inputs);
                HashMap<Integer, Unit> units = ApiRepository.fetchUnits(inputs);
                if (units.isEmpty()) {
                    throw new NoFlatsException();
                } else {
                    TextUi.showUnits(units);
                }
                userInput.clearInputs();
            }
        } catch (EmptyParameterException e) {
            TextUi.showEmptyParameter("FIND", e);
        } catch (NoFlatsException e) {
            TextUi.showNoFlats(e);
        }
    }
}
