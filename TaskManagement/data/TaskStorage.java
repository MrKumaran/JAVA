package Learning.TaskManagement.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TaskStorage {
    private final List<Task> taskList = new ArrayList<>();

    public List<Task> getTaskList() {
        return taskList;
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    public boolean isContainTask(Task task){
        return taskList.contains(task);
    }

    public Task getTaskById(int id){
      try{
        return taskList.stream().filter(task -> task.getId() == id).toList().getFirst();
      }
      catch (NoSuchElementException e){
          return null;
      }
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }
}
