package Learning.ZULA;

import Learning.ZULA.dataClass.Cab;
import Learning.ZULA.dataClass.CabDriver;

import java.util.Scanner;

import static Learning.ZULA.core.*;

public class cabDriversPortal {

    public cabDriversPortal(Scanner s) {
        while (true) {
            System.out.println("""                    
                    1.Cab driver login
                    
                    2.Cab driver signUp
                    
                    3.back
                    """);
            int option = s.nextInt();
            s.nextLine();
            if (option == 1) {
                cabDriverLogin(s);
            } else if (option == 2) {
                cabDriverSignup(s);
                System.out.println("Login");
                cabDriverLogin(s);
            } else {
                return;
            }
        }
    }

    void cabDriverSignup(Scanner s) {
        System.out.print("Enter Driver name: ");
        String name = s.nextLine();
        System.out.print("create password: ");
        int pass = s.nextInt();
        s.nextLine();
        System.out.print("Enter Age: ");
        int age = s.nextInt();
        s.nextLine();
        System.out.print("Enter cab location: ");
        char location = s.nextLine().toUpperCase().charAt(0);
        Cab cab = new Cab(cabs.getLast().getId() + 1, location, 0);
        CabDriver CD = new CabDriver(cabDrivers.getLast().getId() + 1, name, pass, age, cab);
        cabs.add(cab);
        cabDrivers.add(CD);
    }

    void cabDriverLogin(Scanner s) {
        System.out.println("\n");
        System.out.print("Enter Driver Name: ");
        String name = s.nextLine();
        System.out.print("Enter password: ");
        int pass = s.nextInt();
        s.nextLine();
        System.out.println("\n");
        CabDriver CD = null;
        boolean isLogin = false;
        for (CabDriver cd : cabDrivers) {
            if (cd.getName().equals(name) && cd.getPass() == pass) {
                CD = cd;
                isLogin = true;
                break;
            }
        }
        if (!isLogin) {
            System.out.println("Entered credentials are wrong");
            System.out.println("\n");
            return;
        }
        System.out.printf("Cab Id:%d\nCab Driver Name: %s\n", CD.getId(), CD.getName());
        displayTrip(CD, 1);
        s.nextLine();
    }
}
