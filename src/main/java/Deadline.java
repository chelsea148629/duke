public class Deadline extends Task {
    protected String by;
    protected String descriptor;

    public Deadline(String description) {
        super(description);
        String[] parts = description.split("/by ");
        this.descriptor = parts[0];
        this.by = parts[1];
//        this.by = super.ResolveDate(this.by);
        this.type = "D";

    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + descriptor +" (by: " + by + ")";
    }
}
