public class TestVarargs {
    public int TestVarargs(String ...args) {
        // accept 0 or more arguments
        Integer c=0;
        for (String a : args) {
            c+=1;
        }
        return c;
    }

}
