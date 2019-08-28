import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    protected String[] dates = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th",
            "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th",
            "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31th"};

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


    public String ResolveDate(String dateTime){
        DateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy HHmm");
        DateFormat formatter2=new SimpleDateFormat ("dd MMM, yyyy HH:mm a");
        String when = "";
        try {
            Date date = formatter1.parse(dateTime);
            //System.out.println(date);
            System.out.println(formatter2.format(date));
            when = formatter2.format(date);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return when;
    }
}