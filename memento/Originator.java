package Learning.memento;

public class Originator {
    private final Memento memento = new Memento();

    public void write(String string){
        memento.addState(string);
    }

    public String undo(){
        return memento.previousState();
    }
}
