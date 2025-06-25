package Learning.memento;

import java.util.Stack;

public class Caretaker {
    private final Stack<String> previousList = new Stack<>();

    public void push(String string){
        previousList.push(string);
    }

    public String pop(){
        if (previousList.empty()) return "";
        return previousList.pop();
    }

}
