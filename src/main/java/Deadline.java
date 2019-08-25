public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);

        this.by = by;
        this.by = super.ResolveDate(this.by);
    }


    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
