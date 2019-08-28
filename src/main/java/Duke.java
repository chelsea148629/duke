import java.io.*;
import java.security.PublicKey;
import java.util.Scanner;


public class Duke{
    private static void printTask(Task task, Integer listCounter, String line){
        System.out.println(line+"    Got it. I've added this task: \n    "+
                task.toString() +
                "\n    Now you have "+ (listCounter+1)+ " tasks in the list.\n"+line
        );
    }

    private static int loadTask(Task tasks[], Integer listCounter) {
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
                System.out.println(parts[0]+" "+ parts[1] +" "+ parts[2] );
                tasks[listCounter] = new Todo(parts[2]);
                tasks[listCounter].isDone = (parts[1].equals("false"))? false:true;
            }
            else if(parts[0].equals("E")){
                System.out.println(parts[0]+" "+ parts[1] +" "+ parts[2] );
                tasks[listCounter] = new Event(parts[2]);
                tasks[listCounter].isDone = (parts[1].equals("false"))? false:true;
                System.out.println(tasks[listCounter].isDone);
            }else{ //"D"
                System.out.println(parts[0]+" "+ parts[1] +" "+ parts[2]);
                tasks[listCounter] = new Deadline(parts[2]);
                tasks[listCounter].isDone = (parts[1].equals("false"))? false:true;
            }
            listCounter += 1;
        }
        return listCounter;
    }

    private static void saveTask(Task[] tasks, Integer listCounter) {
        System.out.println("saveTask");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("task.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<listCounter; i+=1 ){
//            if(tasks[i].type.equals("E") || tasks[i].type.equals("D"))
//                }
            String str = tasks[i].toString();

            String buf = tasks[i].type + "=" + tasks[i].isDone + "=" + tasks[i].description + "=" +"\n";

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
        Task[] tasks = new Task[100];
        DukeExpectation Expectation = new DukeExpectation();
        int listCounter = 0;
        System.out.println("listcounter = " + listCounter);
        listCounter = loadTask(tasks, listCounter);
        System.out.println("listcounter = " + listCounter);

        while(true){
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            if(userInput.length()>3 && userInput.substring(0, 4).equals("done"))
            {
                int num = Integer.parseInt(userInput.substring(5))-1;
                tasks[num].isDone = true;
                printUnicode.println(line+ "     Nice! I've marked this task as done: \n"+
                        tasks[num].toString()+"\n"+line);
            }
            else if(userInput.length()>7 && userInput.substring(0, 8).equals("deadline"))
            {
                if(userInput.length()==8){
                    Expectation.EmptyDescription("deadline");
                }
                else{
                    tasks[listCounter] = new Deadline(userInput.substring(9));
                    printTask(tasks[listCounter], listCounter, line);
                    listCounter += 1;
                }
            }
            else if(userInput.length()>4 && userInput.substring(0, 5).equals("event"))
            {
                if(userInput.length()==5){
                    Expectation.EmptyDescription("event");
                }
                else{
                    tasks[listCounter] = new Event(userInput.substring(6));
                    printTask(tasks[listCounter], listCounter, line);
                    listCounter += 1;
                }
            }
            else if(userInput.length()>3 && userInput.substring(0, 4).equals("todo"))
            {
                if(userInput.length()==4){
                    Expectation.EmptyDescription("todo");
                }
                else{
                    tasks[listCounter] = new Todo(userInput.substring(5));
                    printTask(tasks[listCounter], listCounter, line);
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
                    printUnicode.println("    "+ i+ ". "+ tasks[i-1].toString());
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

