package seedu.hdbuy.command;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.common.Unit;
import seedu.hdbuy.common.exception.EmptyParameterException;
import seedu.hdbuy.common.exception.NoFlatsException;
import seedu.hdbuy.data.SearchedUnits;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

public class FindCommand extends Command {

    private static final Logger logger = Logger.getLogger("FindCommand");

    @Override public void execute(UserInput userInput) {
        try {
            LinkedHashMap<QueryKey, String> inputs = userInput.getInputs();
            if (inputs.isEmpty()) {
                logger.warning("Unable to execute find command due to an empty filter");
                throw new EmptyParameterException();
            } else {
                TextUi.showParameters(inputs);
                SearchedUnits.clearSearchedUnits();
                ApiRepository.fetchUnits(inputs);
                ArrayList<Unit> units = SearchedUnits.getSearchedUnits();
                if (units.isEmpty()) {
                    throw new NoFlatsException();
                }
                TextUi.showUnits(units);
                userInput.clearInputs();
            }
        } catch (EmptyParameterException e) {
            TextUi.showEmptyParameter("FIND", e);
        } catch (NoFlatsException e) {
            TextUi.showNoFlats(e);
        }
    }
}
