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
        return "["+this.getStatusIcon()+"] "+this.description;
    }


    public String ResolveDate(String dateTime){
        String[] parse = dateTime.split(" ");
        String[] date = parse[0].split("/");

        String day = dates[Integer.parseInt(date[0])-1];
        String month = months[Integer.parseInt(date[1])-1];
        String time;
        if(Integer.parseInt(parse[1].substring(0,2)) < 12){
            if(Integer.parseInt(parse[1].substring(2))==0 ){
                time = parse[1].substring(0,2) + " am";
            }
            else{
                time = parse[1].substring(0,2) + ":"+parse[1].substring(2) + " am";
            }
        }
        else{
            if(Integer.parseInt(parse[1].substring(2))==0 ){
                time = (Integer.parseInt(parse[1].substring(0,2))-12)+" pm";
            }
            else{
                time = (Integer.parseInt(parse[1].substring(0,2))-12) + ":"+parse[1].substring(2) + " am";
            }
        }
        String when = day + " of "+month+" "+date[2]+", "+time;
        return when;
    }
}