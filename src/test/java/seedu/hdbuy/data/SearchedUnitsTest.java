package seedu.hdbuy.data;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import seedu.hdbuy.common.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchedUnitsTest {

    @Test
    void sortMapByPrice() {
        SearchedUnits.clearSearchedUnits();
        Unit textUnit1 = new Unit("JURONG WEST","4 ROOM",429000,990,
            " 82 years 06 months","664A JURONG WEST ST 64",1026083864);
        Unit textUnit2 = new Unit("JURONG WEST","4 ROOM",429001,990,
            " 82 years 06 months","664A JURONG WEST ST 64",1026083864);
        Unit textUnit3 = new Unit("JURONG WEST","4 ROOM",429002,990,
            " 82 years 06 months","664A JURONG WEST ST 64",1026083864);

        SearchedUnits.addToResult(textUnit2);
        SearchedUnits.addToResult(textUnit1);
        SearchedUnits.addToResult(textUnit3);

        assertFalse(SearchedUnits.getSearchedUnits().isEmpty());

        SearchedUnits.sortMapByPrice(true);
        assertEquals(textUnit1.toString(), Objects.requireNonNull(SearchedUnits.getUnit(1)).toString());
        assertEquals(textUnit3.toString(), Objects.requireNonNull(SearchedUnits.getUnit(3)).toString());

        SearchedUnits.sortMapByPrice(false);
        assertEquals(textUnit3.toString(), Objects.requireNonNull(SearchedUnits.getUnit(1)).toString());
        assertEquals(textUnit1.toString(), Objects.requireNonNull(SearchedUnits.getUnit(3)).toString());

        SearchedUnits.clearSearchedUnits();
        assertTrue(SearchedUnits.getSearchedUnits().isEmpty());
    }
}