package Learning.ZULA.dataClass;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int id;
    private String name;
    private int pass;
    private int age;
    private List<Trip> trips;
    public Customer(
            int id,
            String name,
            int pass,
            int age
    ){
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.trips = new ArrayList<>();
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getPass(){
        return this.pass;
    }

    public int getAge(){
        return this.age;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPass(int pass){
        this.pass = pass;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
