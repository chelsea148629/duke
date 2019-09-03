import java.util.ArrayList;
import java.util.TreeSet;

public class TaskList {
    public ArrayList<Task> tasks;
    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    public int size(){
        return tasks.size();
    }

    public Task get(int num) {
        return tasks.get(num);
    }

    public Task remove(int num) {
        return tasks.remove(num);
    }

    public boolean add(Task task) {
        return tasks.add(task);
    }

    public Task done(int num){
        //int num = Integer.parseInt(userInput.substring(5))-1;
        tasks.get(num).isDone = true;
        return tasks.get(num);
    }

    public void delete(int num, int listCounter){
        Ui.Delete(tasks.get(num), listCounter);
        tasks.remove(num);
    }

    public void find(String findSource){
        for(int i=1; i<=tasks.size(); i+=1){
            if(tasks.get(i - 1).description.contains(findSource)){
                System.out.println("    "+ i+ ". "+ tasks.get(i - 1).toString());
            }
        }
    }
}
