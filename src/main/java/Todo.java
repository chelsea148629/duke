public class Todo extends Task{
    public Todo(String description) {
        super(description);
        this.type = "T";
    }


    @Override
    public String toString() {
        return "[T]" + super.toString() + super.description;
    }
}
