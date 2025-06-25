package Learning.memento;

public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.write("Hello");
        originator.write("Hello32");
        originator.write("Hello3232");
        originator.write("Hello22");
        System.out.println(originator.undo());
        System.out.println(originator.undo());
        System.out.println(originator.undo());
        System.out.println(originator.undo());
        System.out.println(originator.undo());
        System.out.println(originator.undo());
    }
}
