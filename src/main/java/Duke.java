import java.util.Scanner;

public class Duke{
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    public Duke() {
    }

    public void run(){
        tasks = new TaskList();
        ui = new Ui();
        parser = new Parser();

        ui.StartLogo();
        DukeException Expectation = new DukeException();
        int listCounter = 0;
        listCounter = Storage.loadTask(tasks, listCounter);

        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String userInput = input.nextLine();
            Command c = parser.parse(userInput);
            if(c.commandType.equals("done")){
                ui.Done(tasks.done(c.index));
            }
            else if(c.commandType.equals("delete")){
                tasks.delete(c.index, listCounter);
                listCounter -= 1;
            }
            else if(c.commandType.equals("find")){
                tasks.find(c.description);
            }
            else if(c.commandType.equals("deadline"))
            {
                tasks.add(new Deadline(c.description));
                ui.Deadline(tasks.get(tasks.size()-1), listCounter);
                listCounter += 1;
            }
            else if(c.commandType.equals("event"))
            {
                tasks.add(new Event(c.description));
                ui.Event(tasks.get(tasks.size()-1), listCounter);
                listCounter += 1;
            }
            else if(c.commandType.equals("todo"))
            {
                tasks.add(new Todo(c.description));
                ui.Todo(tasks.get(tasks.size()-1), listCounter);
                listCounter += 1;
            }
            else if(c.commandType.equals("bye"))
            {
                ui.Bye();
                System.exit(0);
            }
            else if(c.commandType.equals("list")) {
                ui.List(tasks, listCounter);
            }
            else { //expectation
                Expectation.InvalidInput();
            }
            Storage.saveTask(tasks, listCounter);
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}

