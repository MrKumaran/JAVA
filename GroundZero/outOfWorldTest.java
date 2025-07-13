package Learning.GroundZero;

class computer{
    public void myName(){
        System.out.println("I'm a computer1");
    }
}

class laptop extends computer{
    @Override
    public void myName(){
        System.out.println("I'm a laptop");
    }

    public void myCharacteristics() {
        System.out.println("I'm portable");
    }
}

public class outOfWorldTest {
    public static void main(String[] args) {
        computer obj1 = new computer();
        computer obj2 = new laptop();
        laptop obj3 = new laptop();
        obj1.myName();
        obj2.myName();
        obj3.myName();
        obj3.myCharacteristics();
    }
}
