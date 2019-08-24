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

        while(true){
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            if(userInput.equals("bye")){
                System.out.println(line+"    Bye. Hope to see you again soon!\n"+line);
                System.exit(0);
            }
            else{
                System.out.println(line+"    "+userInput+"\n"+line);
            }
        }
    }
}

