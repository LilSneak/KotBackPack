import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Task> toDoList;
    private TasksDAO tasksDataSource;

    public ToDoList(Context c){
        toDoList = new ArrayList<Task>(0);
        tasksDataSource = new TasksDAO(c);
        tasksDataSource.open();
    }
    public Task getTask(int taskID){
        return tasksDataSource.getTaskById(taskID);
    }
    public Task createTask(Task t){
        return tasksDataSource.createTask(t);
    }
    public void deleteTask(Task t){
        tasksDataSource.deleteTask(t);
    }
    public void editTask(Task t){
        tasksDataSource.editTask(t);
    }
    public List<Task> getAllTasks(){
        toDoList = tasksDataSource.getAllTasks();
        return toDoList;
    }
}
