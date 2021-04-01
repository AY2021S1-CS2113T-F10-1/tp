package seedu.hdbuy.command;

import java.util.ArrayList;

import seedu.hdbuy.common.Unit;
import seedu.hdbuy.common.exception.InvalidSortException;
import seedu.hdbuy.common.exception.NoFlatsException;
import seedu.hdbuy.data.SearchedUnits;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.parser.CommandType;
import seedu.hdbuy.ui.TextUi;

public class SortCommand extends Command {
    protected String criteria;

    public SortCommand(String criteria) {
        this.criteria = criteria;
    }

    @Override public void execute(UserInput userInput) {
        try {
            switch (criteria) {
            case CommandType.SORT_ASC:
                SearchedUnits.sortMapByPrice(true);
                break;
            case CommandType.SORT_DESC:
                SearchedUnits.sortMapByPrice(false);
                break;
            default:
                throw new InvalidSortException();
            }
            ArrayList<Unit> sortedUnits = SearchedUnits.getSearchedUnits();
            if (sortedUnits.isEmpty()) {
                throw new NoFlatsException();
            }
            TextUi.showUnits(sortedUnits);
        } catch (InvalidSortException e) {
            TextUi.showInvalidSort(criteria, e);
        } catch (NoFlatsException e) {
            TextUi.showNoFlats(e);
        }
    }
}