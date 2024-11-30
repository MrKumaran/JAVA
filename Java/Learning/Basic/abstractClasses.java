package Learning.Basic;
/*
Abstract method in abstract class define structure. So, which class inherit abstract class that class have to implement
abstract method declared in abstract class.

In java only class can be extended at a time
*/
abstract class animal{
    int age;
    String name;
    String animal;
    abstract void sound();
    void printDetails(){
        System.out.println("Name of " + animal + " is " + name + " and it's age is " + age);
    }
}

class cat extends animal{
    cat(int age, String name, String animal){
        super.age = age;
        super.name = name;
        super.animal = animal;
    }
    @Override
    void sound() {
        System.out.println("Meows");
    }
}

class dog extends animal{
    dog(int age, String name, String animal){
        super.age = age;
        super.name = name;
        super.animal = animal;
    }
    @Override
    void sound() {
        System.out.println("Barks");
    }
}

public class abstractClasses {
    public static void main(String[] args) {
        cat c = new cat(2, "Snowbell", "cat");
        dog d = new dog(4, "Siezer", "dog");
        c.printDetails();
        c.sound();
        d.printDetails();
        d.sound();
    }
}
