import java.security.PublicKey;
import java.util.Scanner;


public class Duke{
    public static void main(String[] args) {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String line = "    ____________________________________________________________\n";
        System.out.println(line+"    Hello! I'm Duke\n    What can I do for you?\n"+line);
        Task[] tasks = new Task[100];
        for(int i=0; i<100; i+=1){
            tasks[i] = new Task("");
        }
        int listCounter = 0;

        while(true){
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            String[] parse = userInput.split(" "); //for input "done 2"

            if(parse[0].equals("done")){
                int num = Integer.parseInt(parse[1]);
                tasks[num].isDone = true;
                System.out.println(line+"     Nice! I've marked this task as done: \n"+
                        tasks[num].getStatusIcon()+tasks[num].description+line);

            }
            if(userInput.equals("bye")){
                System.out.println(line+"    Bye. Hope to see you again soon!\n"+line);
                System.exit(0);
            }
            else if(userInput.equals("list")){
                for(int i=1; i<=listCounter; i+=1){
                    System.out.println(i+". "+tasks[i-1].getStatusIcon()+tasks[i-1].description);
                }
            }
            else{
                System.out.println(line+"    added: "+userInput+"\n"+line);
                System.out.println(tasks[listCounter].description);
                tasks[listCounter].description = userInput;
                listCounter+=1;
                Task task = new Task(userInput);
            }
        }
    }
}

