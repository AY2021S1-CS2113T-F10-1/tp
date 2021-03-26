package seedu.hdbuy.common;

public class Unit {

    private final String location;
    private final String type;
    private final int price;
    private final int leaseValue;
    private final String lease;
    private final String address;
    private final int id;

    public Unit(String location, String type, int price, int leaseValue, String lease, String address, int id) {
        this.location = location;
        this.type = type;
        this.price = price;
        this.leaseValue = leaseValue;
        this.lease = lease;
        this.address = address;
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public int getLeaseValue() {
        return leaseValue;
    }

    public String getLease() {
        return lease;
    }

    @Override public String toString() {
        return "Hash ID: " + getId() + " - Address: " + getAddress() + " - Type: " + getType() + " - Lease: "
                + getLease() + " -  Price: $" + getPrice();
    }
}
