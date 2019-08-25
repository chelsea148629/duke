import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.util.Scanner;


public class Duke{
    private static void printTask(Task task, Integer listCounter, String line){
        System.out.println(line+"    Got it. I've added this task: \n"+
                task.toString() +
                "\nNow you have "+ (listCounter+1)+ " tasks in the list.\n"+line
        );
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
        int listCounter = 0;

        while(true){
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            if(userInput.length()>5 && userInput.substring(0, 5).equals("done "))
            {
                int num = Integer.parseInt(userInput.substring(5))-1;
                tasks[num].isDone = true;
                printUnicode.println(line+ "     Nice! I've marked this task as done: \n"+
                        tasks[num].toString()+line);
            }
            else if(userInput.length()>9 && userInput.substring(0, 9).equals("deadline "))
            {
                String[] parts = userInput.substring(9).split("/");
                tasks[listCounter] = new Deadline(parts[0], parts[1]);
                printTask(tasks[listCounter], listCounter, line);
                listCounter += 1;
            }
            else if(userInput.length()>6 && userInput.substring(0, 6).equals("event "))
            {
                String[] parts = userInput.substring(6).split("/");
                tasks[listCounter] = new Event(parts[0], parts[1]);
                printTask(tasks[listCounter], listCounter, line);
                listCounter += 1;
            }
            else if(userInput.length()>5 && userInput.substring(0, 5).equals("todo "))
            {
                tasks[listCounter] = new Todo(userInput.substring(5));
                printTask(tasks[listCounter], listCounter, line);
                listCounter += 1;
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
                    printUnicode.println("    "+ i+ ". "+
                            "["+tasks[i-1].getStatusIcon()+"] "+
                            tasks[i-1].description);
                }
                System.out.println(line);
            }
            else { //expectation
                System.out.println("OOPS\n");
//                System.out.println(line+"    added: "+userInput+"\n"+line);
//                System.out.println(tasks[listCounter].description);
//                tasks[listCounter].description = userInput;
//                listCounter+=1;
            }
        }
    }
}

