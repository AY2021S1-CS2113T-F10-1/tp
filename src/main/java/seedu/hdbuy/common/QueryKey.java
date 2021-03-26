package seedu.hdbuy.common;

public enum QueryKey {
    LOCATION {
        @Override public String toString() {
            return "LOCATION";
        }
    }, TYPE {
        @Override public String toString() {
            return "TYPE";
        }
    }, LEASE_REMAINING {
        @Override public String toString() {
            return "LEASE_REMAINING";
        }
    }
}
