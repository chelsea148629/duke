public class DukeException {
    public DukeException(){
    }
    public void InvalidInput(){
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                "- deadline <event_name> /by <time: dd/MM/yyyy HHmm>\n" +
                "  event <event_name> /at <time: dd/MM/yyyy HHmm>\n"+
                "  todo <event_name>\n"+
                " - done <event_index>\n"+
                " - list\n" +
                " - bye"
            );
    }
    public void EmptyDescription(String type){
        System.out.println("OOPS!!! The description of a "+type+" cannot be empty.\n" +
                "usage: deadline <event_name> /by <time: dd/MM/yyyy HHmm>\n" +
                "       event <event_name> /at <time: dd/MM/yyyy HHmm>");
    }
    public void WrongFormat(){
        System.out.println("usage: deadline <event_name> /by <time: dd/MM/yyyy HHmm>\n" +
                "       event <event_name> /at <time: dd/MM/yyyy HHmm>\n" +
                "       todo <event_name>");
    }
}
