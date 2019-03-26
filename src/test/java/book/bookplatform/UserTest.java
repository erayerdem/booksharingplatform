package book.bookplatform;


import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertEquals;

public class UserTest {
    static int a = 1;

    @BeforeAll
    static void ccc() {
        a++;
    }

    @Test
    public void testet() {
        System.out.println("hello world");
        assertEquals(2, a);
    }

    @Test
    public void testet1() {

        assertEquals(2, a);
    }
}
