package Learning.Basic;

class genetics <Type0, Type1>{
    Type0 first;
    Type1 second;
    genetics(Type0 first, Type1 second){
        this.first = first;
        this.second = second;
    }
    void print(){
        System.out.println("Entered data's are of type");
        System.out.println(first + " is of type " + first.getClass().getSimpleName());
        System.out.println(second + " is of type " + second.getClass().getSimpleName());
    }
}

public class geneticsInJava {
    public static void main(String[] args) {
        System.out.println();
        genetics<Integer, String> g0 = new genetics<Integer, String>(21, "Hello");
        g0.print();
        System.out.println();
        genetics<Double, Float> g1 = new genetics<Double, Float>(21.3231, 12.4F);
        g1.print();
    }
}
