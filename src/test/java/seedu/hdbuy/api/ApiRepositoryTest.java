package seedu.hdbuy.api;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.data.SearchedUnits;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiRepositoryTest {

    @Test void fetchUnits() {
        LinkedHashMap<QueryKey, String> inputs = new LinkedHashMap<>();
        inputs.put(QueryKey.LOCATION, "ang mo kio");
        inputs.put(QueryKey.TYPE, "4 room");
        inputs.put(QueryKey.LEASE_REMAINING, "80");
        ApiRepository.fetchUnits(inputs);
        assertNotNull(SearchedUnits.getSearchedUnits());
    }

    @Test public void testEmptyResponseException() {
        LinkedHashMap<QueryKey, String> inputs = new LinkedHashMap<>();
        inputs.put(QueryKey.LEASE_REMAINING, "101");
        SearchedUnits.clearSearchedUnits();
        ApiRepository.fetchUnits(inputs);
        assertTrue(SearchedUnits.getSearchedUnits().isEmpty());
    }
}