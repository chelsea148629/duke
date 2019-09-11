public class TestVarargs {
    public int TestVarargs(String ...args) {
        // accept 0 or more arguments
        Integer count=0;
        for (String a : args) {
            count+=1;
        }
        return count;
    }

}
