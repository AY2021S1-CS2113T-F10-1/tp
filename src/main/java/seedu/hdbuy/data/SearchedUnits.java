package seedu.hdbuy.data;

import java.util.ArrayList;
import java.util.logging.Logger;

import seedu.hdbuy.common.Unit;

public class SearchedUnits {

    private static ArrayList<Unit> units;

    public static void addToResult(Unit unit) {
        if (units == null) {
            units = new ArrayList<>();
        }
        units.add(unit);
    }

    public static Unit getUnit(int index) {
        if (units == null) {
            Logger.getLogger("SearchedUnits").severe("Did not perform search before");
            return null;
        }
        try {
            return units.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            Logger.getLogger("SearchedUnits").severe("Invalid index");
            return null;
        }
    }

    public static void clearSearchedUnits() {
        if (units == null) {
            units = new ArrayList<>();
        }
        units.clear();
    }

    public static ArrayList<Unit> getSearchedUnits() {
        if (units == null) {
            units = new ArrayList<>();
        }
        return units;
    }

    public static void sortMapByPrice(boolean isAscending) {
        if (units == null) {
            Logger.getLogger("SearchedUnits").severe("Did not perform search before");
            return;
        }
        units.sort((unit1, unit2) -> {
            if (isAscending) {
                return unit1.getPrice() - unit2.getPrice();
            } else {
                return unit2.getPrice() - unit1.getPrice();
            }
        });
    }
}
