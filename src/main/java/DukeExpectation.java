public class DukeExpectation {
    public DukeExpectation(){
    }
    public void InvalidInput(){
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
    public void EmptyDescription(String type){
        System.out.println("OOPS!!! The description of a "+type+" cannot be empty.");
    }
}
