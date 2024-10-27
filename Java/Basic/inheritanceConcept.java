package Basic;

/*
Four types of inheritance
 -> Single inheritance
 -> Multilevel inheritance
 -> Hierarchical inheritance
 -> Hybrid inheritance
Note: In java there is no multiple inheritance concept available.

Four types of Access specifiers
 -> Private
 -> Public
 -> Protected
 -> Default

Only one class can extend at a time
*/
class base{
    void baseClassMethod(){
        System.out.println("This is Base class Method");
    }
}
class derived extends base{
    void derivedClassMethod(){
        System.out.println("This is Derived Class Method");
    }
}

public class inheritanceConcept {
    public static void main(String[] args) {
        base b = new base();
        derived d = new derived();
        b.baseClassMethod();
        d.derivedClassMethod();
        System.out.println("Accessing base class method from derived class");
        d.baseClassMethod();
    }
}
