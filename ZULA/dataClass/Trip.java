package Learning.ZULA.dataClass;

public class Trip {
    private char sourceLocation;
    private char destinationLocation;
    private int customer_id;
    private int cab_id;
    private int zulaCommission;
    private int fare;
    private final float zulaCommissionRate = 0.3F;
    public Trip(
            char sourceLocation,
            char destinationLocation,
            int customer_id,
            int cab_id,
            int fare
    ){
        this.customer_id = customer_id;
        this.cab_id = cab_id;
        this.fare = fare;
        this.sourceLocation = sourceLocation;
        this.zulaCommission = (int)(fare * zulaCommissionRate);
        this.destinationLocation = destinationLocation;
    }

    public char getDestinationLocation() {
        return destinationLocation;
    }

    public char getSourceLocation() {
        return sourceLocation;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getCab_id() {
        return cab_id;
    }

    public int getZulaCommission() {
        return zulaCommission;
    }

    public int getFare() {
        return fare;
    }

    public void setSourceLocation(char sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public void setDestinationLocation(char destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setCab_id(int cab_id) {
        this.cab_id = cab_id;
    }

    public void setZulaCommission(int zulaCommission) {
        this.zulaCommission = zulaCommission;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
