package seedu.hdbuy.command;

import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.exception.InvalidSortException;
import seedu.hdbuy.ui.TextUi;
import seedu.hdbuy.api.UnitsGenerator;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class SortCommand extends Command {
    protected String criteria;

    public SortCommand(String criteria) {
        this.criteria = criteria;
    }

    public static HashMap<QueryKey, String> sortMapByValueDesc(boolean order, HashMap<QueryKey, String> inputs) {
        List list = new LinkedList(inputs.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        if (order == true) {
            Collections.reverse(list);
        }
        HashMap<QueryKey, String> result = new LinkedHashMap<QueryKey, String>();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry<QueryKey, String> entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @Override public void execute(HashMap<QueryKey, String> inputs) {
        try {
            switch (criteria) {
            case "asc":
                sortMapByValueDesc(true,inputs);
                break;
            case "desc":
                sortMapByValueDesc(false,inputs);
                break;
            default:
                throw new InvalidSortException();
            }
            TextUi.showParameters(inputs);
        } catch (InvalidSortException e) {
            TextUi.showInvalidSort(criteria, e);
        }
    }
}
