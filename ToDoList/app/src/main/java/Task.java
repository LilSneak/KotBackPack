public class Task {
    private int taskId;
    private String date;
    private String task;
    private boolean isCompleted;

    public Task(){

    }
    public void setTaskId(int id){
        taskId = id;
    }
    public void setDate(String d){
        date = d;
    }
    public void setTask(String t){
        task = t;
    }
    public void setCompleted(boolean c){
        isCompleted = c;
    }

    public void getid(){
        return taskId;
    }
    public void getdate(){
        return date;
    }
    public void getTaskDetails(){
        return task;
    }
    public void getCompleted(){
        return isCompleted;
    }

    public String toString(){
        String result = "";
        result += task + " " + date;
        return result;
    }
}
