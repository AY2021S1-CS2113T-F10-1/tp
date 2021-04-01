package seedu.hdbuy.storage;

import org.junit.jupiter.api.Test;

import seedu.hdbuy.common.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UnitDecoderTest {

    @Test void textToUnit() {
        String text = "1026083864:664A JURONG WEST ST 64:4 ROOM:990: 82 years 06 months:429000:JURONG WEST";
        Unit unit = UnitDecoder.textToUnit(text);
        Unit textUnit = new Unit("JURONG WEST","4 ROOM",429000,990,
                " 82 years 06 months","664A JURONG WEST ST 64",1026083864);
        assert unit != null;
        assertEquals(textUnit.toString(), unit.toString());
    }

    @Test void textToUnitIsNull() {
        String text = "";
        Unit unit = UnitDecoder.textToUnit(text);
        assertNull(unit);
    }
}