package Learning.memento;

public class Memento {
    private final Caretaker caretaker = new Caretaker();
    private String currentState;

    public void addState(String string) {
        if (currentState == null){
            currentState = string;
        }
        else {
            caretaker.push(currentState);
            currentState = string;
        }
    }


    public String previousState(){
        currentState = caretaker.pop();
        return currentState;
    }
}
