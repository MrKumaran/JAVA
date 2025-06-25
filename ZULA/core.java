package Learning.ZULA;

import Learning.ZULA.dataClass.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class core {
    public static List<Cab> cabs = new ArrayList<>();
    public static List<CabDriver> cabDrivers = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();
    public static List<Customer> customers = new ArrayList<>();
    public static List<Character> path = new ArrayList<>();

    public void dashBoard() {
        Scanner s = new Scanner(System.in);
        initialize();
        while (true) {
            System.out.println("""
                    Welcome to ZULA!!
                    
                    1.Cab driver portal
                    
                    2.Customer login
                    
                    3.Administration login
                    
                    4.Quit
                    """);
            int i = s.nextInt();
            s.nextLine();
            if (i == 1) {
                new cabDriversPortal(s);
            } else if (i == 2) {
                new customerPortal().customerLogin(s);
            } else if (i == 3) {
                new adminPortal(s);
            } else if (i == 4) {
                System.out.println("Exiting thanks for using ZULA!");
                break;
            } else {
                System.out.println("Invalid response, provide valid response");
            }
        }
    }

    public static void displayTrip(CabDriver CD, int source) {
        System.out.println();
        System.out.print("Trip Details:");
        List<Trip> trips = CD.getCab().getTrips();
        if (trips.isEmpty()) {
            System.out.print(" No trips given\n");
        } else {
            System.out.println();
            if (source == 0) {
                System.out.printf("%-10s %-15s %-20s %-10s %-10s\n", "Source", "Destination", "Customer details", "Fare", "ZULA commission");
            } else {
                System.out.printf("%-10s %-15s %-20s %-20s %-10s\n", "Source", "Destination", "Customer details", "ZULA commission", "Fare");
            }
        }
        for (Trip trip : trips) {
            if (source == 0) {
                System.out.printf("%-10c %-15c %-20d %-10d %-10d\n", trip.getSourceLocation(), trip.getDestinationLocation(), trip.getCustomer_id(), trip.getFare(), (int) (trip.getFare() * .3));
            } else {
                System.out.printf("%-10c %-15c %-20d %-21d %-10d\n", trip.getSourceLocation(), trip.getDestinationLocation(), trip.getCustomer_id(), (int) (trip.getFare() * .3), trip.getFare());
            }
        }
        System.out.println();
    }

    void initialize() {
        cabs.add(new Cab(1, 'D', 0));
        cabs.add(new Cab(2, 'G', 0));
        cabs.add(new Cab(3, 'H', 0));
        cabs.add(new Cab(4, 'A', 0));

        cabDrivers.add(new CabDriver(1, "aaa", 111, 25, cabs.get(0)));
        cabDrivers.add(new CabDriver(2, "bbb", 222, 36, cabs.get(1)));
        cabDrivers.add(new CabDriver(3, "ccc", 333, 31, cabs.get(2)));
        cabDrivers.add(new CabDriver(4, "ddd", 444, 28, cabs.get(3)));

        locations.add(new Location(1, 'A', 0));
        locations.add(new Location(3, 'C', 4));
        locations.add(new Location(4, 'D', 7));
        locations.add(new Location(6, 'F', 9));
        locations.add(new Location(2, 'B', 15));
        locations.add(new Location(7, 'G', 18));
        locations.add(new Location(8, 'H', 20));
        locations.add(new Location(5, 'E', 23));

        customers.add(new Customer(1, "WW", 55, 25));
        customers.add(new Customer(2, "XX", 66, 36));
        customers.add(new Customer(3, "YY", 77, 31));
        customers.add(new Customer(4, "ZZ", 88, 28));

        path.add('A');
        path.add('C');
        path.add('D');
        path.add('F');
        path.add('B');
        path.add('G');
        path.add('H');
        path.add('E');
    }
}
