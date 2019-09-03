public class Parser {
    public Command command;
    private DukeException Expectation;

    public Parser(){
        this.command = new Command();
        this.Expectation = new DukeException();

    }

    public Command parse(String userInput) {
        if (userInput.length() > 3 && userInput.substring(0, 4).equals("done")) {
            this.command.commandType = "done";
            command.index = Integer.parseInt(userInput.substring(5))-1;
        }
        else if(userInput.length()>5 && userInput.substring(0, 6).equals("delete")){
            command.commandType = "delete";
            command.index = Integer.parseInt(userInput.substring(7))-1;
        }
        else if(userInput.length()>3 && userInput.substring(0, 4).equals("find")){
            if(userInput.length()==4) this.Expectation.EmptyDescription("find");
            else{
                command.commandType = "find";
                command.description = userInput.substring(5);
            }
        }
        else if(userInput.length()>7 && userInput.substring(0, 8).equals("deadline")){
            if(!userInput.contains("/by")) Expectation.WrongFormat();
            else{
                command.commandType = "deadline";
                command.description = userInput.substring(9);
            }
        }
        else if(userInput.length()>4 && userInput.substring(0, 5).equals("event")){
            if(!userInput.contains("/at")) Expectation.WrongFormat();
            else{
                command.commandType = "event";
                command.description = userInput.substring(6);
            }
        }
        else if(userInput.length()>3 && userInput.substring(0, 4).equals("todo")){
            if(userInput.length()==4){
                Expectation.EmptyDescription("todo");
            }
            else{
                command.commandType = "todo";
                command.description = userInput.substring(5);
            }

        }
        else if(userInput.equals("bye")){
            command.commandType = "bye";
        }
        else if(userInput.equals("list")){
            command.commandType = "list";
        }
        return command;
    }

}
