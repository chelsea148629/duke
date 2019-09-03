import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    public static int loadTask(TaskList tasks, Integer listCounter) {
//        File file = new File("../src/main/java/task.txt");
        File file = new File("task.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()){
            String[] parts = sc.nextLine().split("=");

            if(parts[0].equals("T")){
                tasks.add(new Todo(parts[2]));
                tasks.get(listCounter).isDone = (parts[1].equals("false"))? false:true;
            }
            else if(parts[0].equals("E")){
                tasks.add(new Event(parts[2]));
                tasks.get(listCounter).isDone = (parts[1].equals("false"))? false:true;
            }else{ //"D"
                tasks.add(new Deadline(parts[2]));
                tasks.get(listCounter).isDone = (parts[1].equals("false"))? false:true;
            }
//            System.out.println("equal false? " + parts[1].equals("false"));
//            System.out.println("isDone?" + tasks[listCounter].isDone);
            listCounter += 1;
        }
        return listCounter;
    }
    public static void saveTask(TaskList tasks, Integer listCounter) {
        //System.out.println("saveTask");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("task.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<listCounter; i+=1 ){
            String str = tasks.get(i).toString();
            String buf = tasks.get(i).type + "=" + tasks.get(i).isDone + "=" + tasks.get(i).description + "=" +"\n";
            try {
                writer.append(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
