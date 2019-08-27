public class Event extends Task{
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.at = super.ResolveDate(this.at);
        this.type = "E";
    }
    @Override
    public String toString() {
        return "    [E]" + super.toString() + " (at: " + at + ")";
    }
}

