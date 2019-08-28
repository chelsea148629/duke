public class Event extends Task{
    protected String at;
    protected String descriptor;

    public Event(String description) {
        super(description);
        String[] parts = description.split("/at ");
        this.descriptor = parts[0];
        this.at = parts[1];
//        this.at = super.ResolveDate(this.at);
        this.type = "E";
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + descriptor + " (at: " + at + ")";
    }
}

