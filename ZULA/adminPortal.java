package Learning.ZULA;

import Learning.ZULA.dataClass.CabDriver;

import java.util.Scanner;

import static Learning.ZULA.core.cabDrivers;
import static Learning.ZULA.core.displayTrip;

public class adminPortal {
    public adminPortal(Scanner s) {
        for (CabDriver CD : cabDrivers) {
            int totalFare = CD.getCab().getFareEarned();
            System.out.printf("""
                    Cab Id: %d
                    
                    Total Number of Trips: %d
                    
                    Total Fare Collected: %d
                    
                    Total ZULA Commission: %d
                    """, CD.getCab().getId(), CD.getCab().getTrips().size(), totalFare, (int) (totalFare * 0.3));
            displayTrip(CD, 0);
        }
        System.out.println("press enter to go back...");
        s.nextLine();
    }
}
