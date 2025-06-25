package Learning.ZULA.dataClass;

public class CabDriver {
    private final int id;
    private String name;
    private int pass;
    private int age;
    private Cab cab;
    public CabDriver(
            int id,
            String name,
            int pass,
            int age,
            Cab cab
    ){
        this.pass = pass;
        this.id = id;
        this.age = age;
        this.name = name;
        this.cab = cab;
    }

    public void SetName(String name){
        this.name = name;
    }

    public void setPass(int pass){
        this.pass = pass;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
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

    public Cab getCab() {
        return this.cab;
    }

}