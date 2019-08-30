import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke{
    private static void printTask(Task task, Integer listCounter, String line){
        System.out.println(line+"    Got it. I've added this task: \n    "+
                task.toString() +
                "\n    Now you have "+ (listCounter+1)+ " tasks in the list.\n"+line
        );
    }

    private static int loadTask(ArrayList<Task> tasks, Integer listCounter) {
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

    private static void saveTask(ArrayList<Task> tasks, Integer listCounter) {
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

    public static void main(String[] args) throws UnsupportedEncodingException {
        PrintStream printUnicode = new PrintStream(System.out, true, "UTF-8");

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String line = "    ____________________________________________________________\n";
        System.out.println(line+"    Hello! I'm Duke\n    What can I do for you?\n"+line);
        ArrayList<Task> tasks = new ArrayList<>();
        DukeExpectation Expectation = new DukeExpectation();
        int listCounter = 0;
        listCounter = loadTask(tasks, listCounter);

        while(true){
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            if(userInput.length()>3 && userInput.substring(0, 4).equals("done"))
            {
                int num = Integer.parseInt(userInput.substring(5))-1;
                tasks.get(num).isDone = true;
                printUnicode.println(line+ "     Nice! I've marked this task as done: \n"+
                        tasks.get(num).toString()+"\n"+line);
            }
            else if(userInput.length()>5 && userInput.substring(0, 6).equals("delete")){
                int num = Integer.parseInt(userInput.substring(7))-1;
                System.out.println(line+ "     Noted. I've removed this task: \n"+
                        tasks.get(num).toString()+"\n"+
                        "    Now you have 4 tasks in the list." + "\n" + line);
                tasks.remove(num);
            }
            else if(userInput.length()>7 && userInput.substring(0, 8).equals("deadline"))
            {
                if(!userInput.contains("/by")) Expectation.WrongFormat();
                else{
                    tasks.add(new Deadline(userInput.substring(9)));
                    printTask(tasks.get(listCounter), listCounter, line);
                    listCounter += 1;
                }
            }
            else if(userInput.length()>4 && userInput.substring(0, 5).equals("event"))
            {
                if(!userInput.contains("/at")) Expectation.WrongFormat();
                else{
                    tasks.add(new Event(userInput.substring(6)));
                    printTask(tasks.get(listCounter), listCounter, line);
                    listCounter += 1;
                }
            }
            else if(userInput.length()>3 && userInput.substring(0, 4).equals("todo"))
            {
                if(userInput.length()==4){
                    Expectation.EmptyDescription("todo");
                }
                else{
                    tasks.add(new Todo(userInput.substring(5)));
                    System.out.println(userInput.substring(5));
                    printTask(tasks.get(listCounter), listCounter, line);
                    listCounter += 1;
                }
            }
            else if(userInput.equals("bye"))
            {
                System.out.println(line+"    Bye. Hope to see you again soon!\n"+line);
                System.exit(0);
            }
            else if(userInput.equals("list"))
            {
                System.out.println(line+"     Here are the tasks in your list:");
                for(int i=1; i<=listCounter; i+=1){
                    printUnicode.println("    "+ i+ ". "+ tasks.get(i - 1).toString());
                }
                System.out.println(line);
            }
            else { //expectation
                Expectation.InvalidInput();
            }
            saveTask(tasks, listCounter);
        }
    }
}

