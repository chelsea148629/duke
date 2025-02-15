
import java.util.Date;

public class Deadline extends Task {
    protected String by;
    protected String descriptor;

    public Deadline(String description) {
        super(description);
        String[] parts = description.split("/by ");
        this.descriptor = parts[0];
        this.by = parts[1];
        this.type = "D";
    }

    /**
     * @return String: [D/T/E] [v/x] <task descriptor> (by: <date>)
     */

    @Override
    public String toString() {
        Date date = super.ResolveDate(this.by);
        if(!(date==null)){
            return "[D]" + super.toString() + descriptor +" (by: " + date + ")";
        }
        else{
            return "[D]" + super.toString() + descriptor +" (by: " + by + ")";
        }
    }


}
