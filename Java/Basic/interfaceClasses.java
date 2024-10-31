package Basic;

interface vehicle{
    int engineCount = 1; // can't change as it is final and static
    void details(String bodyType, float topSpeed, int wheelCount, float cc, String manufacture, int year, String model);
}

class bike implements vehicle{
    int wheelCount;
    float cc;
    String bodyType;
    float topSpeed;
    String manufacture;
    String model;
    int year;

    @Override
    public void details(String bodyType, float topSpeed, int wheelCount, float cc, String manufacture, int year, String model) {
        this.wheelCount = wheelCount;
        this.cc = cc;
        this.bodyType = bodyType;
        this.topSpeed = topSpeed;
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
    }

    public void printDetails() {
        System.out.printf("This Bike was manufactured by %s Model %s in year %d\n", manufacture, model, year);
        System.out.printf("It's top speed is %.1f powered by %.1f cc engine with %s", topSpeed, cc, bodyType);
    }
}

public class interfaceClasses {
    public static void main(String[] args) {
        bike b = new bike();
        b.details("Sports type Body", 120F, 2, 149.9F, "Yamaha", 2023, "FZs-fi");
        b.printDetails();
    }
}
