import java.util.ArrayList;

public class Ui {
    private static String line = "    ____________________________________________________________\n";

    private static void printTask(Task task, Integer listCounter){
        System.out.println(line+"    Got it. I've added this task: \n    "+
                task.toString() +
                "\n    Now you have "+ (listCounter+1)+ " tasks in the list.\n"+line
        );
    }

    public static void StartLogo(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(line+"    Hello! I'm Duke\n    What can I do for you?\n"+line);
    }

    public static void List(TaskList tasks, int listCounter){
        System.out.println(line+"     Here are the tasks in your list:");
        for(int i=1; i<=listCounter; i+=1){
            System.out.println("    "+ i+ ". "+ tasks.get(i - 1).toString());
        }
        System.out.println(line);
    }

    public static void Done(Task task){
        System.out.println(line+ "     Nice! I've marked this task as done: \n"+
                task.toString()+"\n"+line);
    }

    public static void Delete(Task task, int listCounter){
        System.out.println(line+ "     Noted. I've removed this task: \n"+
                task.toString()+"\n"+
                "    Now you have "+ (listCounter +1) + " tasks in the list." + "\n" + line);
    }

    public static void Todo(Task task, int listCounter){
        printTask(task, listCounter);
    }

    public static void Event(Task task, int listCounter){
        printTask(task, listCounter);
    }

    public static void Deadline(Task task, int listCounter){
        printTask(task, listCounter);
    }

    public static void Bye(){
        System.out.println(line+"    Bye. Hope to see you again soon!\n"+line);
    }
}
