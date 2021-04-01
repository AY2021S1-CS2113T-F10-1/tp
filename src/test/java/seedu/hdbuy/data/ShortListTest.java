package seedu.hdbuy.data;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import seedu.hdbuy.common.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShortListTest {

    @Test
    void modifyShortlist() {
        ArrayList<Unit> units = ShortList.getShortListedUnits();
        assertNotNull(units);
        Unit unit = new Unit("JURONG WEST","4 ROOM",429000,990,
                " 82 years 06 months","664A JURONG WEST ST 64",1026083864);
        ShortList.addToShortList(unit);
        int max = ShortList.getShortListedUnits().size();
        assertEquals(unit.toString(), ShortList.getShortListedUnits().get(max - 1).toString());

        Unit removedUnit = ShortList.removeFromShortList(max);
        assertNotNull(removedUnit);
        assertEquals(unit.toString(), removedUnit.toString());
        assertEquals(max - 1, ShortList.getShortListedUnits().size());
    }
}