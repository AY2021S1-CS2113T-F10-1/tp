package seedu.hdbuy.api;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import seedu.hdbuy.common.QueryKey;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryFormatterTest {

    @Test
    void formQuery() {
        LinkedHashMap<QueryKey, String> parameters = new LinkedHashMap<>();
        parameters.put(QueryKey.LOCATION, "ang mo kio");
        parameters.put(QueryKey.TYPE, "4 room");
        parameters.put(QueryKey.LEASE_REMAINING, "80");

        StringBuilder queryBody = new StringBuilder();
        for (Map.Entry<QueryKey, String> parameter : parameters.entrySet()) {
            QueryKey key = parameter.getKey();
            String value = parameter.getValue();
            if (value.contains(" ")) {
                value = value.replaceAll("\\s", "%20");
            }

            assert !key.equals(QueryKey.LOCATION) || value.equals("ang%20mo%20kio");
            assert !key.equals(QueryKey.TYPE) || value.equals("4%20room");

            switch (key) {
            case TYPE:
                String type = String.format("\"flat_type\":\"%s\"", value);
                queryBody.append(type);
                break;
            case LOCATION:
                String location = String.format("\"town\":\"%s\"", value);
                queryBody.append(location);
                break;
            case LEASE_REMAINING:
                String lease = String.format("\"remaining_lease\":\"%s\"", value);
                queryBody.append(lease);
                break;
            default:
                continue;
            }
            queryBody.append(",");
        }
        queryBody.deleteCharAt(queryBody.length() - 1);
        String output = String.format("{%s}", queryBody.toString());
        assertEquals("{\"town\":\"ang%20mo%20kio\",\"flat_type\":\"4%20room\",\"remaining_lease\":\"80\"}",
                output);
    }
}