import java.util.Date;

public class Command {
    public String commandType;
    public int index;
    public String description;
    public String when;
    public Date date;
    public String middle;


    public Command(){
        this.commandType = "";
        this.index = -1;
        this.when = "";
        this.date = null;
        this.middle = "";
        this.description = "";
    }
}
