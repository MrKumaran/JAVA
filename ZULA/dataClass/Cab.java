package Learning.ZULA.dataClass;

import java.util.ArrayList;
import java.util.List;

public class Cab {
    private final int id;
    private char location;
    private int fareEarned;
    private final List<Trip> trips;
    private boolean isAvailable;
    private boolean isOnRest;
    private int skippedRides;
    public Cab(int id, char location, int fareEarned){
        this.id = id;
        this.location = location;
        this.fareEarned = fareEarned;
        this.trips = new ArrayList<>();
        this.skippedRides = 0;
        this.isAvailable = true;
        this.isOnRest = false;
    }

    public void addTrip(Trip trip){
        trips.add(trip);
        this.fareEarned += trip.getFare();
        this.skippedRides = 0;
        this.isAvailable = false;
        this.isOnRest = true;
        this.location = trip.getDestinationLocation();
    }

    public void updateAvailability() {
        if (this.isOnRest) {
            this.skippedRides++;
            if (skippedRides > 1) {
                this.isAvailable = true;
                isOnRest = false;
                this.skippedRides = 0;
            }
        }
    }

    public int getId(){
        return this.id;
    }

    public char getLocation(){
        return this.location;
    }

    public int getFareEarned(){
        return this.fareEarned;
    }

    public List<Trip> getTrips(){
        return this.trips;
    }

    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    public void setLocation(char location){
        this.location = location;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}