import java.util.Scanner;


public class Duke{
    /**
     * testing.
     */

    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        */
        String line = "    ____________________________________________________________\n";
        System.out.println(line+"    Hello! I'm Duke\n    What can I do for you?\n"+line);
        String[] list = new String[100];
        int listCounter = 0;
        while(true){
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            if(userInput.equals("bye")){
                System.out.println(line+"    Bye. Hope to see you again soon!\n"+line);
                System.exit(0);
            }
            if(userInput.equals("list")){
                for(int i=1; i<=listCounter; i+=1){
                    System.out.println(i+". "+list[i-1]);
                }
            }
            else{
                System.out.println(line+"    added: "+userInput+"\n"+line);
                list[listCounter] = userInput;
                listCounter+=1;
            }
        }
    }
}

