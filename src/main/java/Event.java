import java.util.Date;

public class Event extends Task{
    protected String at;
    protected String descriptor;

    public Event(String description) {
        super(description);
        String[] parts = description.split("/at ");
        this.descriptor = parts[0];
        this.at = parts[1];
        this.type = "E";
    }
    @Override
    public String toString() {
        Date date = super.ResolveDate(this.at);
        if(!(date==null)) {
            return "[E]" + super.toString() + descriptor + " (at: " + date + ")";
        }
        else{
            return "[E]" + super.toString() + descriptor + " (at: " + at + ")";
        }
    }
}

