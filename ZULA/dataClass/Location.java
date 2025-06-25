package Learning.ZULA.dataClass;

public class Location{
    private final int id;
    private final char name;
    private final int distanceFromOrigin;
    public Location(
            int id,
            char name,
            int distanceFromOrigin
    ){
        this.id = id;
        this.name = name;
        this.distanceFromOrigin = distanceFromOrigin;
    }


    public int getId() {
        return id;
    }

    public char getName() {
        return name;
    }

    public int getDistanceFromOrigin() {
        return distanceFromOrigin;
    }
}