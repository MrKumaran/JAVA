package Learning.ZULA;

import Learning.ZULA.dataClass.Cab;
import Learning.ZULA.dataClass.Customer;
import Learning.ZULA.dataClass.Trip;

import java.util.List;
import java.util.Scanner;

import static Learning.ZULA.core.*;

public class customerPortal {

    public void customerLogin(Scanner s) {
        System.out.println("\n");
        System.out.print("Enter Customer Name: ");
        String name = s.nextLine();
        System.out.print("Enter password: ");
        int pass = s.nextInt();
        s.nextLine();
        System.out.println("\n");
        Customer customer = null;
        boolean isLogin = false;
        for (Customer c : customers) {
            if (c.getName().equals(name) && c.getPass() == pass) {
                customer = c;
                isLogin = true;
                break;
            }
        }
        if (!isLogin) {
            System.out.println("Entered credentials are wrong");
            System.out.println("\n");
            return;
        }
        while (true) {
            System.out.println("""                   
                    1.Show trip history
                    
                    2.Book a cab
                    
                    3.Back
                    
                    """);
            int i = s.nextInt();
            s.nextLine();
            if (i == 1) {
                customerTrips(customer);
            } else if (i == 2) {
                bookARide(s, customer);
            } else if (i == 3) {
                return;
            } else {
                System.out.println("Invalid response, provide valid response");
            }
        }
    }

    void customerTrips(Customer customer) {
        List<Trip> trips = customer.getTrips();
        System.out.printf("""
                Customer Id: %d
                Customer Name: %s
                """, customer.getId(), customer.getName());
        System.out.print("Trip Details:");
        if (trips.isEmpty()) {
            System.out.print(" No trips given\n");
        } else {
            System.out.println();
            System.out.printf("%s %10s %10s %10s\n", "Source", "Destination", "CabDetail", "Fare");
            for (Trip trip : trips) {
                System.out.printf("%6c %11c %10d %10d\n", trip.getSourceLocation(), trip.getDestinationLocation(), trip.getCab_id(), trip.getFare());
            }
        }
    }

    void bookARide(Scanner s, Customer customer) {
        currentCabLocations();
        Cab nearByCab = null;
        int minDistance = Integer.MAX_VALUE;
        System.out.println();
        char source;
        char destination;
        while (true) {
            System.out.print("Enter Source: ");
            source = s.nextLine().toUpperCase().charAt(0);
            if (path.contains(source)) break;
            else System.out.println("""
                    Enter valid source
                    A
                    C
                    D
                    F
                    B
                    G
                    H
                    E
                    """);
        }
        while (true) {
            System.out.print("Enter destination: ");
            destination = s.nextLine().toUpperCase().charAt(0);
            if (path.contains(destination)) break;
            else System.out.println("""
                    Enter valid source
                    A
                    C
                    D
                    F
                    B
                    G
                    H
                    E
                    """);
        }
        for (Cab cab : cabs) {
            if (cab.getIsAvailable()) {
                int distance = distance(cab.getLocation(), source);
                if (minDistance > distance) {
                    nearByCab = cab;
                    minDistance = distance;
                } else if (minDistance == distance) {
                    if (nearByCab.getTrips().size() > cab.getTrips().size()) {
                        nearByCab = cab;
                    }
                }
            }
        }
        int price = distance(source, destination) * 10;
        System.out.println("Cab fare: " + price);
        while (true) {
            System.out.println("""
                    
                    Y -> confirm booking
                    N -> cancel booking
                    
                    """);
            char confirm = s.nextLine().toUpperCase().charAt(0);
            if (confirm == 'Y') {
                Trip nextTrip = new Trip(source, destination, customer.getId(), nearByCab.getId(), price);
                customer.getTrips().add(nextTrip);
                nearByCab.addTrip(nextTrip);
                updateOtherCabs(nearByCab);
                return;
            } else if (confirm == 'N') return;
            else {
                System.out.println("Select valid option");
            }
        }

    }

    void updateOtherCabs(Cab selectedCab) {
        for (Cab cab : cabs) {
            if (!cab.equals(selectedCab)) {
                cab.updateAvailability();
            }
        }
    }

    void currentCabLocations() {
        System.out.println();
        System.out.printf("%10s %10s\n", "Location", "Cab IDs");
        for (Cab cab : cabs) {
            System.out.printf("%10c %10d\n", cab.getLocation(), cab.getId());
        }
    }

    int distance(char source, char destination) {
        int sourceFromOrigin = locations.get(path.indexOf(source)).getDistanceFromOrigin();
        int destionationFromOrigin = locations.get(path.indexOf(destination)).getDistanceFromOrigin();
        return Math.abs(sourceFromOrigin - destionationFromOrigin);
    }

}
