package seedu.hdbuy.api;

import seedu.hdbuy.common.QueryKey;

import java.util.HashMap;
import java.util.Map;

public class QueryFormatter {

    /**
     * Converts user inputs into query string to be sent to database.
     *
     * @param parameters User inputs in map format.
     * @return Valid query string.
     */
    public static String formQuery(HashMap<QueryKey, String> parameters) {
        StringBuilder queryBody = new StringBuilder();
        for (Map.Entry<QueryKey, String> parameter : parameters.entrySet()) {
            QueryKey key = parameter.getKey();
            String value = parameter.getValue();
            if (value.contains(" ")) {
                value = value.replaceAll("\\s", "%20");
            }
            assert !value.contains(" ") : "Request will fail due to whitespace in query";
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
        return String.format("{%s}", queryBody.toString());
    }
}
