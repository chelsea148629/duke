import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void SimpleTest(){
        Todo T = new Todo("TodoTest");

        assertEquals(T.toString(), "[T]TodoTest");
    }
}
