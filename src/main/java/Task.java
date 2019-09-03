import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.type = "N";
    }

    public String getStatusIcon() {
        return (isDone ? "v":"x");
        //return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String toString(){
        return "["+this.getStatusIcon()+"] ";
    }

    public Date ResolveDate(String dateTime){
        DateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy HHmm");
        DateFormat formatter2=new SimpleDateFormat ("dd/MM/yyyy" );
        Date date = null;
        try {
            date = formatter1.parse(dateTime);
            //System.out.println(date);
        } catch (ParseException e) {
            try {
                date = formatter2.parse((dateTime));
                //System.out.println(date);
            } catch (ParseException ex) {
                //System.out.println("       Duke cannot resolve the date format :(((");
            }
        }
        return date;
    }


}